class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                grid[i][j] += i == m - 1 && j == n - 1 ? 0
                        : i == m - 1 ? grid[i][j + 1]
                                : j == n - 1 ? grid[i + 1][j]
                                        : Math.min(grid[i + 1][j], grid[i][j + 1]);
        // for (int i = 0; i < m; i++)
        //     System.out.println(Arrays.toString(grid[i]));
        return grid[0][0];
    }
}