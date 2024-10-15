class Solution {
    int[] nums;
    int target, n;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;
        return solve(0, 0);
    }
    private int solve(int idx, int total){
        if(idx == n)
            return total == target ? 1 : 0;
        return 
            solve(idx + 1, total + nums[idx]) + solve(idx + 1, total - nums[idx]);
    }
}