class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        return solve(dp, n);
    }
    private int solve(Integer[] dp, int i){
        if(i==0)
            return 1;
        else if(i<0)
            return 0;
        if(dp[i]!=null)
            return dp[i];
        return dp[i] = solve(dp, i-1) + solve(dp, i-2);
    }
}