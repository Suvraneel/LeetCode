class Solution {
    private void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++)
            System.out.println(Arrays.toString(mat[i]));
        System.out.println();
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, maxDim = Math.min(m, n), count = 0;
        // generate prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                prefix[i + 1][j + 1] = sum += matrix[i][j];
        }
        // print(prefix);
        for (int j = 0; j <= n; j++)
            for (int i = 0; i < m; i++)
                prefix[i + 1][j] += prefix[i][j];
        // print(prefix);
        for (int k = 1; k <= maxDim; k++) {
            // System.out.println("k->" + k);
            for (int i = k; i <= m; i++) {
                for (int j = k; j <= n; j++) {
                    // System.out.print(prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k] + "\t");
                    if (prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k] == k * k)
                        count++;
                }
                // System.out.println();
            }
        }
        return count;
    }
}