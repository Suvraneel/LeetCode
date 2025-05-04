class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, d = 0, x = 0, y = 0;
        int rStart = 0, rEnd = m - 1, cStart = 0, cEnd = n - 1;
        List<Integer> res = new ArrayList<>();
        boolean redirected = false;
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int j = cStart; j <= cEnd; j++)
                res.add(matrix[rStart][j]);
            rStart++;
            for (int i = rStart; i <= rEnd; i++)
                res.add(matrix[i][cEnd]);
            cEnd--;
            if (rStart <= rEnd)
                for (int j = cEnd; j >= cStart; j--)
                    res.add(matrix[rEnd][j]);
            rEnd--;
            if (cStart <= cEnd)
                for (int i = rEnd; i >= rStart; i--)
                    res.add(matrix[i][cStart]);
            cStart++;
        }
        return res;
    }
}