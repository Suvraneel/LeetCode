class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; n > 0; i++) {
            if (n % 2 == 1)
                powers.add(1 << i);
            n = n >> 1;
        }
        int[] pdtQuery = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            pdtQuery[i] = 1;
            for(int j=queries[i][0]; j<=queries[i][1]; j++)
                pdtQuery[i] = (int)((1l * pdtQuery[i] * powers.get(j)) % MOD);
        }
        return pdtQuery;
    }
}