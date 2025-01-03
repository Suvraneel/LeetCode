class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, sum = 0, validSplits = 0;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        for (int i = 0; i < n - 1; i++)
            if (prefixSum[i] >= prefixSum[n - 1] - prefixSum[i])
                validSplits++;
        return validSplits;
    }
}