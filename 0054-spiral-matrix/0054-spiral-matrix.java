class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, i1 = 0, i2 = m - 1, j1 = 0, j2 = n - 1, d = 0, x = 0, y = -1;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k < m * n; k++) {
            int[] move = dirs[d];
            if (x + move[0] < i1 || x + move[0] > i2 || y + move[1] < j1 || y + move[1] > j2) {
                switch (d) {
                    case 0 -> i1++;
                    case 1 -> j2--;
                    case 2 -> i2--;
                    case 3 -> j1++;
                }
                d = (d + 1) % 4;
                k--;
            } else {
                x += move[0];
                y += move[1];
                // System.out.println(matrix[x][y]);
                ans.add(matrix[x][y]);
            }
        }
        return ans;
    }
}