class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        List<Integer> row = triangle.get(n - 1);
        // System.out.println(row);
        for (int j = 0; j < n; j++)
            dp[n - 1][j] = row.get(j);
        for (int i = n - 2; i >= 0; i--) {
            row = triangle.get(i);
            // System.out.println(row);
            for (int j = 0; j < row.size(); j++)
                dp[i][j] = row.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][0];
    }
}