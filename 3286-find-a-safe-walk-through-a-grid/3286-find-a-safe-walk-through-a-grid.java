class Solution {
    int m, n;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        this.m = grid.size();
        this.n = grid.get(0).size();
        int[][] bestRun = new int[m][n];
        return solve(grid, health, 0, 0, bestRun);
    }

    boolean solve(List<List<Integer>> grid, int health, int r, int c, int[][] bestRun) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return false;
        health -= grid.get(r).get(c);
        if (health <= bestRun[r][c])
            return false;
        bestRun[r][c] = health;
        if (r == m - 1 && c == n - 1 && health > 0)
            return true;
        boolean ans = false;
        for (int[] d : dirs) {
            int i = r + d[0], j = c + d[1];
            ans |= solve(grid, health, i, j, bestRun);
        }
        return ans;
    }
}