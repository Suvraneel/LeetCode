class Solution {
    public int assignEdgeWeights(int[][] edges) {
        // Construct graph (adjacency list)
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        // Find max depth
        int maxDepth = dfs(1, adj, 0);
        int MOD = 1_000_000_007;
        int ans = 1;
        while (--maxDepth > 0)
            ans = (ans * 2) % MOD;
        return ans;
    }

    int dfs(int node, Map<Integer, List<Integer>> adj, int parent) {
        int maxDepth = 0;
        if (!adj.containsKey(node))
            return 0;
        for (int child : adj.get(node)) {
            if (child == parent)
                continue;
            maxDepth = Math.max(maxDepth, dfs(child, adj, node) + 1);
        }
        return maxDepth;
    }
}