class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] mat = new int[rowSum.length][colSum.length];
        for (int i = 0, j = 0; i < rowSum.length && j < colSum.length;) {
            mat[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= mat[i][j];
            colSum[j] -= mat[i][j];
            if (rowSum[i] == 0)
                i++;
            else
                j++;
            // System.out.println(Arrays.toString(mat[i]));
        }
        return mat;
    }
}