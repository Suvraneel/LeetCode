class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] q = questions[i];
            int nextValidIdx = i + 1 + q[1];
            long skip = dp[i + 1];
            long solve = nextValidIdx < n ? dp[nextValidIdx] : 0;
            dp[i] = Math.max(q[0] + solve, skip);
        }
        return dp[0];
    }
}