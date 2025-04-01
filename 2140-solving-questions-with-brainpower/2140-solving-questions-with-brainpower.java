class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return solve(questions, 0, dp);
    }

    private long solve(int[][] questions, int idx, long[] dp) {
        if (idx >= questions.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int[] q = questions[idx];
        long skip = solve(questions, idx + 1, dp);
        long solve = q[0] + solve(questions, idx + 1 + q[1], dp);
        return dp[idx] = Math.max(skip, solve);
    }
}