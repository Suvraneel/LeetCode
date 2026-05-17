class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, lt = 0, rt = m * n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int i = mid / n, j = mid % n;
            if (target == matrix[i][j])
                return true;
            else if (matrix[i][j] < target)
                lt = mid + 1;
            else
                rt = mid - 1;
        }
        return false;
    }
}