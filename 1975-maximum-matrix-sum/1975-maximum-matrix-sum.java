class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        long sum = 0, modMin = 100001;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val < 0) {
                    count++;
                    val = -val;
                }
                sum += val;
                modMin = Math.min(modMin, val);
            }
        }
        return count % 2 == 0 ? sum : sum - 2 * modMin;
    }
}