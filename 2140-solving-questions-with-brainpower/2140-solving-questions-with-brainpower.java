class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int[] q = questions[i];
            int nextValidIdx = i + 1 + q[1];
            long skip = i < n - 1 ? dp[i + 1] : 0;
            long solve = nextValidIdx < n ? dp[nextValidIdx] : 0;
            dp[i] = Math.max(q[0] + solve, skip);
        }
        return dp[0];
    }
}