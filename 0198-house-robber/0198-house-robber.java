class Solution {
    int n;
    public int rob(int[] nums) {
        this.n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(nums, memo, 0);
    }

    private int solve(int[] nums, int[] memo, int lt) {
        if (lt > n - 1)
            return 0;
        if(memo[lt]!=-1)
            return memo[lt];
        return memo[lt] = Math.max(solve(nums, memo, lt + 1), nums[lt] + solve(nums, memo, lt + 2));
    }
}