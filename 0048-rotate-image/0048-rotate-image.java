class Solution {
    public void rotate(int[][] matrix) {
        // arr[i][j] -> arr[i][n-1-j]
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++)
            for(int j=i+1; j<n; j++)
                swap(matrix, i, j, j, i);
        for(int i=0; i<m; i++)
            for(int j=0; j<n/2; j++)
                swap(matrix, i, j, i, n-1-j);
    }
    private void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}