class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length, maxSubArraySum = nums[0], currSubArraySum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i])
                currSubArraySum += nums[i];
            else {
                maxSubArraySum = Math.max(maxSubArraySum, currSubArraySum);
                currSubArraySum = nums[i];
            }
        }
        return Math.max(maxSubArraySum, currSubArraySum);
    }
}