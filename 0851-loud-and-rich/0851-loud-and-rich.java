class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] edge : richer)
            adj[edge[1]].add(edge[0]);
        for (int i = 0; i < n; i++)
            dfs(adj, quiet, memo, i);
        return memo;
    }

    private int dfs(List<Integer>[] adj, int[] quiet, int[] memo, int node) {
        if(memo[node]!=-1)
            return memo[node];
        memo[node] = node;
        for (int nbr : adj[node]) {
            int quietestNbr = dfs(adj, quiet, memo, nbr);
            if (quiet[quietestNbr] < quiet[memo[node]])
                memo[node] = quietestNbr;
        }
        return memo[node];
    }
}