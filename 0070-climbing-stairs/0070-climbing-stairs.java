class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    private int solve(int n){
        if(n<=2)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = solve(n-1) + solve(n-2);
    }
}