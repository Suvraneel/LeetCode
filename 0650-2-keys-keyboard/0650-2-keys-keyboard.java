class Solution {
    int n;

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        this.n = n;
        int[][] dp = new int[n + 1][n / 2 + 1];
        return 1 + solve(1, 1, dp);
    }

    private int solve(int total, int clipboard, int[][] dp) {
        if (total > n)
            return 1000;
        if (total == n)
            return 0;
        if (dp[total][clipboard] != 0)
            return dp[total][clipboard];
        return dp[total][clipboard] = Math.min(
                solve(total + clipboard, clipboard, dp) + 1,
                solve(total * 2, total, dp) + 2);
    }
}