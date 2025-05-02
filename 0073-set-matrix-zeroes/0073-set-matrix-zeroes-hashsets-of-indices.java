class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> Is = new HashSet<>();
        Set<Integer> Js = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Is.add(i);
                    Js.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (Is.contains(i) || Js.contains(j))
                    matrix[i][j] = 0;
    }
}