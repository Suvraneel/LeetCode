class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int i, int xor) {
        if (i >= nums.length)
            return xor;
        return solve(nums, i + 1, xor ^ nums[i]) + solve(nums, i + 1, xor);
    }
}