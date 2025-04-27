class Solution {
    public int maxSubArray(int[] nums) {
        int prefixSum = 0, n = nums.length, maxPrefixSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefixSum < 0)
                prefixSum = 0;
            prefixSum += nums[i];
            maxPrefixSum = Math.max(prefixSum, maxPrefixSum);
        }
        return maxPrefixSum;
    }
}