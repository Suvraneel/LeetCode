class Solution {
    int[] nums;
    int target, n;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;
        int[][] dp = new int[n][target];
        for(int i=0; i<target; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, 0, dp);
    }
    private int solve(int idx, int total, int[][] dp){
        if(idx == n)
            return total == target ? 1 : 0;
        if(dp[idx][total]!=-1)
            return dp[idx][total];
        return dp[idx][total] =
            solve(idx + 1, total + nums[idx], dp) + solve(idx + 1, total - nums[idx], dp);
    }
}