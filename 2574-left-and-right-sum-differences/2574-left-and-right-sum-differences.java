class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length, sum = 0;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++)
            prefixSum[i] = sum += nums[i];
        for (int i = 0; i < n; i++) // reuse for ans = rtSum-ltSum+self = (total-ltSum)-ltSum+n[i]
            prefixSum[i] = Math.abs(sum - 2 * prefixSum[i] + nums[i]);
        return prefixSum;
    }
}