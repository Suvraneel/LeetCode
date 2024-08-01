class Solution {
    public int[] countBits(int n) {
        if (n == 0)
            return new int[]{0};
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1, ceil = 1; i <= n; i++) {
            if (i == ceil * 2) {
                ceil *= 2;
                dp[i] = 1;
            } else
                dp[i] = dp[ceil] + dp[i - ceil];
        }
        return dp;
    }
}