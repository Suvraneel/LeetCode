class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row0 = new boolean[m];
        boolean[] col0 = new boolean[n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(matrix[i][j]==0){
                    row0[i] = true;
                    col0[j] = true;
                }
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(row0[i] || col0[j])
                    matrix[i][j] = 0;
    }
}