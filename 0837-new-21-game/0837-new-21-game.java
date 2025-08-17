class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double prefix = k == 0 ? 0 : 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = prefix / maxPts;
            if (i < k) // game is incomplete
                prefix += dp[i];
            if (i - maxPts >= 0 && i - maxPts < k) // i-maxPts E [0, k)
                prefix -= dp[i - maxPts];
        }
        double sum = 0;
        for (int i = k; i <= n; i++)
            sum += dp[i];
        return sum;
    }
}