class Solution {
    int m, n;
    int[][] memo;

    public int maxMoves(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        memo = new int[m][n];
        int maxPathLen = 0;
        for (int i = 0; i < m; i++)
            maxPathLen = Math.max(maxPathLen, backtrack(grid, i, 0, -1, 0));
        return maxPathLen;
    }

    private int backtrack(int[][] grid, int r, int c, int prevVal, int pathLen) {
        if (r < 0 || c < 0 || r >= m || c >= n || prevVal >= grid[r][c])
            return pathLen - 1;
        if (memo[r][c] != 0)
            return memo[r][c];
        return memo[r][c] = Math.max(
                backtrack(grid, r - 1, c + 1, grid[r][c], pathLen + 1),
                Math.max(backtrack(grid, r, c + 1, grid[r][c], pathLen + 1),
                        backtrack(grid, r + 1, c + 1, grid[r][c], pathLen + 1)));
    }

}