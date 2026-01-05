class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        long sum = 0, modMin = Math.abs(matrix[0][0]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    count++;
                    sum += -matrix[i][j];
                    modMin = Math.min(modMin, -matrix[i][j]);
                } else {
                    sum += matrix[i][j];
                    modMin = Math.min(modMin, matrix[i][j]);
                }
            }
        }
        return count % 2 == 0 ? sum : sum - 2 * modMin;
    }
}