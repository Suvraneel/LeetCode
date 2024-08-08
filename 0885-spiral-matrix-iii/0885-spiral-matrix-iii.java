class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;
        int[][] path = new int[n][2];
        path[0] = new int[] { rStart, cStart };
        for (int i = 1, x = 1, dir = 1; i < n; x++, dir *= -1) {
            for (int j = 0; j < x && i < n; j++) {
                cStart += dir;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols)
                    path[i++] = new int[] { rStart, cStart };
            }
            for (int j = 0; j < x && i < n; j++) {
                rStart += dir;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols)
                    path[i++] = new int[] { rStart, cStart };
            }
        }
        return path;
    }
}