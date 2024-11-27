class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            adj[i].add(i + 1);
        }
        adj[n - 1].clear();
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            adj[q[0]].add(q[1]);
            answer[i] = bfs(n, adj);
        }
        return answer;
    }

    private int bfs(int n, List<Integer>[] adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(0);
        int nodesAtLevel = 1, pathLen = 0;
        while (!q.isEmpty()) {
            if (nodesAtLevel == 0) {
                nodesAtLevel = q.size();
                pathLen++;
            }
            int node = q.poll();
            if (node == n - 1)
                return pathLen;
            nodesAtLevel--;
            for (int nbr : adj[node]) {
                if (vis[nbr])
                    continue;
                q.offer(nbr);
                vis[nbr] = true;
            }
        }
        return -1;
    }
}