class Solution {
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        int runningSum = 0;
        int[] suffixSum = new int[n];
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = piles[i] + runningSum;
            runningSum = suffixSum[i];
        }
        // System.out.println(Arrays.toString(suffixSum));
        return solve(suffixSum, dp, 0, 1);
    }

    private int solve(int[] suffixSum, int[][] dp, int lt, int m) {
        if (lt + 2 * m >= n)
            return suffixSum[lt];
        if (dp[lt][m] > 0)
            return dp[lt][m];
        int nextMove = suffixSum[lt];
        for (int x = 1; x <= 2 * m && lt + x < n; x++) 
            nextMove = Math.min(nextMove, solve(suffixSum, dp, lt + x, Math.max(m, x)));
        // System.out.println(nextMove);
        return dp[lt][m] = suffixSum[lt] - nextMove;
    }
}