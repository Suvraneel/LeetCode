class Solution {
    int INF = Integer.MAX_VALUE, m, n;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] minCost = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(minCost[i], INF);
        minCost[m - 1][n - 1] = grid[m - 1][n - 1];
        dfs(grid, 0, 0, minCost);
        return minCost[0][0];
    }

    private int dfs(int[][] grid, int i, int j, int[][] minCost) {
        if (i >= m || j >= n)
            return Integer.MAX_VALUE;
        if (minCost[i][j] != INF)
            return minCost[i][j];
        return minCost[i][j] = grid[i][j] +
                Math.min(dfs(grid, i + 1, j, minCost), dfs(grid, i, j + 1, minCost));
    }
}