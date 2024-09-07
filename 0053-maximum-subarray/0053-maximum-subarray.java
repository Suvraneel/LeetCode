class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        int[] memo = new int[n];
        memo[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (memo[i - 1] < 0)
                memo[i] = nums[i];
            else
                memo[i] = memo[i - 1] + nums[i];
            maxSum = Math.max(maxSum, memo[i]);
        }
        return maxSum;
    }
}