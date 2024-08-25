class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] vis = new boolean[n + 1];
        vis[0] = true;
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : times)
            adj[e[0]].add(new int[] { e[1], e[2] });
        return djikstra(adj, vis, n, k);
    }

    private int djikstra(List<int[]>[] adj, boolean[] vis, int n, int src) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });
        int maxCost = -1;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (vis[top[0]])
                continue;
            maxCost = Math.max(maxCost, top[1]);
            vis[top[0]] = true;
            for (int[] nbr : adj[top[0]])
                if (!vis[nbr[0]])
                    pq.add(new int[] { nbr[0], top[1] + nbr[1] });
        }
        for (boolean v : vis)
            if (!v)
                return -1;
        return maxCost;
    }
}