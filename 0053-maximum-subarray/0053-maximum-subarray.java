class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0], prefixSum = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum += nums[i];
            if (prefixSum < nums[i])
                prefixSum = nums[i];
            maxSum = Math.max(maxSum, prefixSum);
        }
        return maxSum;
    }
}