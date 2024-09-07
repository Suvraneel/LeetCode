class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0], prefixSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (prefixSum < 0)
                prefixSum = nums[i];
            else
                prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum);
        }
        return maxSum;
    }
}