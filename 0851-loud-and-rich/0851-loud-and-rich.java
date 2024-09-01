class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] ans = new int[n], memo = new int[n];
        Arrays.fill(memo, -1);
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] edge : richer)
            adj[edge[1]].add(edge[0]);
        for (int i = 0; i < n; i++)
            ans[i] = dfs(adj, quiet, memo, new boolean[n], i);
        return ans;
    }

    private int dfs(List<Integer>[] adj, int[] quiet, int[] memo, boolean[] vis, int node) {
        if(memo[node]!=-1)
            return memo[node];
        if (vis[node])
            return node;
        vis[node] = true;
        int quietest = node;
        for (int nbr : adj[node]) {
            int quietestNbr = dfs(adj, quiet, memo, vis, nbr);
            if (quiet[quietestNbr] < quiet[quietest])
                quietest = quietestNbr;
        }
        return memo[node] = quietest;
    }
}