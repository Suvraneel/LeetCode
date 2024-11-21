class Solution {
    private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int count = 0;
        int[][] grid = new int[m][n];
        for (int[] w : walls)
            grid[w[0]][w[1]] = 1; // blocked
        for (int[] g : guards)
            grid[g[0]][g[1]] = 1; // blocked
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 2; // unblock temp.
            for (int[] d : dir) {
                for (int i = g[0], j = g[1]; i >= 0 && i < m && j >= 0 && j < n
                        && grid[i][j] != 1; i += d[0], j += d[1]) {
                    if (grid[i][j] == 0) // new
                        count++;
                    grid[i][j] = 2; // visited
                }
            }
            grid[g[0]][g[1]] = 1; // block back
        }
        // System.out.println(count);
        return m * n - count - guards.length - walls.length;
    }
}