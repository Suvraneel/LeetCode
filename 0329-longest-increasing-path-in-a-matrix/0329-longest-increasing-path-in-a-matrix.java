class Solution {
    private static int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                dp[i][j] = move(matrix, dp, i, j);
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        return maxLen;
    }

    private int move(int[][] matrix, int[][] dp, int r, int c) {
        if (dp[r][c] != 0)
            return dp[r][c];
        dp[r][c] = 1;
        for (int[] dir: dirs) {
            int newRow = r + dir[0], newCol = c + dir[1];
            if (isValid(newRow, newCol) && matrix[newRow][newCol] > matrix[r][c])
                dp[r][c] = Math.max(dp[r][c], 1 + move(matrix, dp, newRow, newCol));
        }
        return dp[r][c];
    }

    private boolean isValid(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return false;
        return true;
    }
}