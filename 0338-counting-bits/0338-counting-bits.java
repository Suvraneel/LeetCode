class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1, ceil=1; i<=n; i++){
            if(i==ceil*2)
                ceil *= 2;
            dp[i] = dp[i-ceil] + 1;
        }
        return dp;
    }
}