class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        Set<Pair<Integer, Integer>> erased = new HashSet<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    eraseIsland(grid, erased, m, n, i, j);
                    count++;
                }
        if (count != 1) // Already disconnected grid
            return 0;
        // System.out.println(erased);
        if (erased.size() < 3)
            return erased.size();
        for (Pair<Integer, Integer> p : erased) {
            int i = p.getKey(), j = p.getValue();
            if (erased.contains(new Pair(i - 1, j - 1)) && erased.contains(new Pair(i - 1, j))
                    && erased.contains(new Pair(i, j - 1)))
                return 2;
        }
        return 1;
    }

    private void eraseIsland(int[][] grid, Set<Pair<Integer, Integer>> erased, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return;
        erased.add(new Pair(i, j));
        grid[i][j] = 0;
        eraseIsland(grid, erased, m, n, i - 1, j);
        eraseIsland(grid, erased, m, n, i + 1, j);
        eraseIsland(grid, erased, m, n, i, j - 1);
        eraseIsland(grid, erased, m, n, i, j + 1);
    }
}