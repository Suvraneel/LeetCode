class Solution {
    int[] nums;
    int target, n, range;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;
        range = Arrays.stream(nums).sum();
        int[][] dp = new int[n][2 * range + 1];
        for (int[] r: dp)
            Arrays.fill(r, -1);
        return solve(0, 0, dp);
    }

    private int solve(int idx, int total, int[][] dp) {
        if (idx == n)
            return total == target ? 1 : 0;
        if (dp[idx][total + range] != -1)
            return dp[idx][total + range];
        return dp[idx][total + range] = solve(idx + 1, total + nums[idx], dp) + solve(idx + 1, total - nums[idx], dp);
    }
}