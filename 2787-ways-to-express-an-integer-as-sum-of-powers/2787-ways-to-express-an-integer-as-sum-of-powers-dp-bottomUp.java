class Solution {

    public int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;
        long memo[] = new long[n + 1];
        memo[0] = 1;
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int nk = (int) Math.pow(i, x);
            for (int j = n; j >= nk; j--)
                memo[j] += memo[j - nk];
        }
        return (int) (memo[n] % MOD);
    }
}