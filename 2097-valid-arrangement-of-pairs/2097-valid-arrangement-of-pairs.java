class Solution {
    int n;
    boolean found;

    public int[][] validArrangement(int[][] pairs) {
        n = pairs.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] vis = new boolean[n];
        int[][] path = new int[n][2];
        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(pairs[i][0], new ArrayList<>());
            adj.get(pairs[i][0]).add(i);
        }
        // System.out.println(adj);
        for (int i = 0; i < n; i++) {
            vis[i] = true;
            path[0] = pairs[i];
            path = dfs(i, pairs, adj, vis, path, 1);
            vis[i] = false;
            if (found)
                return path;
        }
        return path;
    }

    private int[][] dfs(int src, int[][] pairs,
            Map<Integer, List<Integer>> adj,
            boolean[] vis, int[][] path, int pathLen) {
        if (pathLen == n) {
            found = true;
            return path;
        }
        for (int nbr : adj.getOrDefault(pairs[src][1], new ArrayList<>())) {
            if (vis[nbr])
                continue;
            vis[nbr] = true;
            path[pathLen] = pairs[nbr];
            int[][] res = dfs(nbr, pairs, adj, vis, path, pathLen + 1);
            if (found)
                return res;
            vis[nbr] = false;
        }
        return path;
    }
}