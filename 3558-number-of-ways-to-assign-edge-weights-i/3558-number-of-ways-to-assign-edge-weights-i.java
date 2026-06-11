class Solution {
    public int assignEdgeWeights(int[][] edges) {
        // Construct graph (adjacency list)
        int n = edges.length;
        List<Integer>[] adj = new List[n + 2];
        for (int i = 0; i < n + 2; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        // Find max depth via dfs
        int maxDepth = dfs(1, adj, 0);
        // Calc. odd parity of 1 weighted edges, rest 2, viz - nC1+nC3+nC5+...nCn_or_n-1
        // Above series equates to 2^(n-1) via binary expansion
        // Now instead of pow(2, n-1)%10e7, we will use fast exponentiation
        return fastExponentiation(2, maxDepth - 1);
    }

    int dfs(int node, List<Integer>[] adj, int parent) {
        int maxDepth = 0;
        for (int child : adj[node]) {
            if (child == parent)
                continue;
            maxDepth = Math.max(maxDepth, dfs(child, adj, node) + 1);
        }
        return maxDepth;
    }

    static final int MOD = 1_000_000_007;

    int fastExponentiation(int x, int y) { // calc x^n % 10e7
        long ans = 1;
        long base = x;
        while (y > 0) {
            if ((y & 1) == 1)
                ans = (ans * base) % MOD;
            base = (base * base) % MOD;
            y >>= 1;
        }
        return (int) ans;
    }
}