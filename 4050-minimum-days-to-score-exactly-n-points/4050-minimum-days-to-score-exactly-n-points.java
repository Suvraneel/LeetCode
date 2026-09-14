class Solution {
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int j = 1; j <= n; j++) {
            int sum = 0;
            for (int m = 1; (sum += m) <= j; m++) {
                if (sum == j) // Compute atomic scores
                    dp[j] = Math.min(dp[j], m);
                else if (dp[j - sum] != Integer.MAX_VALUE) // Compute composite if atomic found
                    dp[j] = Math.min(dp[j], m + 1 + dp[j - sum]);
            }
        }
        return dp[n];
    }
}