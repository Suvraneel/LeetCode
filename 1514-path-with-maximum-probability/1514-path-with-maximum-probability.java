class Solution {
    private record Node(int idx, double prob) {
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Node>[] adj = new List[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new Node(edges[i][1], succProb[i]));
            adj[edges[i][1]].add(new Node(edges[i][0], succProb[i]));
        }
        return dijkstra(adj, vis, start_node, end_node);
    }

    private double dijkstra(List<Node>[] adj, boolean[] vis, int src, int dest) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Node(src, 1d));
        while (!pq.isEmpty()) {
            Node best = pq.poll();
            // System.out.println(best);
            vis[best.idx] = true;
            if (best.idx == dest)
                return best.prob;
            for (Node nbr : adj[best.idx])
                if(!vis[nbr.idx])
                    pq.offer(new Node(nbr.idx, best.prob * nbr.prob));
        }
        return 0d;
    }
}