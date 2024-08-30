class Solution {
    private static final int INF = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            if (e[2] != -1) { // ignore negative edges so that Djikstra is applicable
                adj[e[0]].add(new int[] { e[1], e[2] });
                adj[e[1]].add(new int[] { e[0], e[2] });
            }
        }
        int currShortestPathLen = djikstra(adj, source, destination);
        if (currShortestPathLen < target) {
            // implying even if there were +ve edges instead of -ve -1s,
            // there would exist a shorter path. Hence, modifying -ve edges would be useless
            return new int[0][0];
        }
        boolean matchesTarget = (currShortestPathLen == target);
        for (int[] edge : edges) {
            if (edge[2] != -1)
                continue; // Skip edges with already known weights

            // Set edge weight to a large value if current distance matches target,
            // else set to minimum +ve value i.e., +1
            edge[2] = matchesTarget ? INF : 1;
            adj[edge[0]].add(new int[] { edge[1], edge[2] });
            adj[edge[1]].add(new int[] { edge[0], edge[2] });
            if (!matchesTarget) {
                // Compute the new shortest distance with the updated edge weight
                int newDistance = djikstra(adj, source, destination);
                if (newDistance <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDistance;
                }
            }
        }
        // Return modified edges if the target distance is achieved,
        // otherwise return an empty result
        return matchesTarget ? edges : new int[0][0];
    }

    private int djikstra(List<int[]>[] adj,  int src, int dest) {
        int[] cost = new int[adj.length];
        Arrays.fill(cost, INF);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (top[0] == dest)
                return top[1];
            for (int[] nbr : adj[top[0]]) {
                int newCost = top[1] + nbr[1];
                if (cost[nbr[0]] > newCost) {
                    cost[nbr[0]] = newCost;
                    pq.add(new int[] { nbr[0], newCost });
                }
            }
        }
        return INF;
    }
}