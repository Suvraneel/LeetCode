class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        List<Integer>[] adj1 = build(edges1);
        List<Integer>[] adj2 = build(edges2);
        int colorEvensInTree2 = dfs(adj2, 0, -1, 1); // odd colored will be the inverse nodes => m - even colored
        int maxTargetsInTree2 = Math.max(colorEvensInTree2, m - colorEvensInTree2); // for infinite hops, only 2 color combos are possible, either select node 0, or one of node 0's neightbors.
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = maxTargetsInTree2 + dfs(adj1, i, -1, 0);
        return ans;
    }

    private List<Integer>[] build(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        return adj;
    }

    private int dfs(List<Integer>[] adj, int src, int parent, int hops) {
        int targets = hops % 2 == 0 ? 1 : 0;
        for (int nbr : adj[src])
            if (nbr != parent)
                targets += dfs(adj, nbr, src, hops + 1);
        return targets;
    }
}