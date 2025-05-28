class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        List<Integer>[] adj1 = new List[n];
        List<Integer>[] adj2 = new List[m];
        for (int i = 0; i < n; i++)
            adj1[i] = new ArrayList<>();
        for (int i = 0; i < m; i++)
            adj2[i] = new ArrayList<>();
        for (int[] e : edges1) {
            adj1[e[0]].add(e[1]);
            adj1[e[1]].add(e[0]);
        }
        for (int[] e : edges2) {
            adj2[e[0]].add(e[1]);
            adj2[e[1]].add(e[0]);
        }
        int[] ans = new int[n];
        // Assuming we connect any node u from tree1 to a node v in tree2, after 1 hop (u->v),
        // the rest k-1 steps are identical wrt v (and u will play no role in that). Find v_max_contrib.
        // Then ans[u] = nodes within k hops in tree1 from u + the constant v_max_contrib;
        int maxContribTree2 = 0;
        for (int i = 0; i < m; i++)
            maxContribTree2 = Math.max(maxContribTree2, findNeighborsWithinKHops(adj2, i, k - 1, -1));
        for (int i = 0; i < n; i++)
            ans[i] = maxContribTree2 + findNeighborsWithinKHops(adj1, i, k, -1);
        return ans;
    }

    private int findNeighborsWithinKHops(List<Integer>[] adj2, int src, int k, int parent) {
        if (k < 0)
            return 0;
        int nbrCt = 1;
        for (int nbr : adj2[src])
            if (nbr != parent)
                nbrCt += findNeighborsWithinKHops(adj2, nbr, k - 1, src);
        return nbrCt;
    }
}