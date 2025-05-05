class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        long[] dp = new long[4];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        if (n < 4)
            return (int) dp[n - 1];
        for (int i = 4; i <= n; i++) {
            dp[3] = (2 * dp[2] + dp[0]) % MOD;
            for (int j = 0; j < 3; j++)
                dp[j] = dp[j + 1];
        }
        return (int) dp[3];
    }
}