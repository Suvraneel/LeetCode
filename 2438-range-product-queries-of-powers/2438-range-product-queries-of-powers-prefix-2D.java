class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; n > 0; i++) {
            if (n % 2 == 1)
                powers.add(1 << i);
            n = n >> 1;
        }
        int m = powers.size();
        int[][] prefixPdt = new int[m][m];
        for (int i = 0; i < m; i++) {
            long curr = 1;
            for (int j = i; j < m; j++) {
                curr *= powers.get(j);
                prefixPdt[i][j] = (int) (curr %= MOD);
            }
        }
        int[] pdtQuery = new int[queries.length];
        int i = 0;
        for (int[] q : queries)
            pdtQuery[i++] = prefixPdt[q[0]][q[1]];
        return pdtQuery;
    }
}