class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m - 2; i++)
            for (int j = 0; j < n - 2; j++)
                if (isMagicSq(grid, i, j))
                    ans++;
        return ans;
    }

    private boolean isMagicSq(int[][] grid, int rowStart, int colStart) {
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagSum = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cell = grid[rowStart + i][colStart + j];
                if (cell == 0 || cell > 9)
                    return false;
                rowSum[i] += cell;
                colSum[i] += grid[rowStart + j][colStart + i];
            }
            diagSum[0] += grid[rowStart + i][colStart + i];
            diagSum[1] += grid[rowStart + i][colStart + 2 - i];
        }
        // System.out.println(Arrays.toString(rowSum));
        // System.out.println(Arrays.toString(colSum));
        // System.out.println(Arrays.toString(diagSum));
        int match = diagSum[0];
        for (int i = 0; i < 3; i++)
            if (rowSum[i] != match || colSum[i] != match)
                return false;
        return match == diagSum[1];
    }
}