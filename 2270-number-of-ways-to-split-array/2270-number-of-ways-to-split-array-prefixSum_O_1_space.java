class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, validSplits = 0;
        long sum = 0, total = 0;
        for (int i = 0; i < n; i++)
            total += nums[i];
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            if (sum >= total - sum)
                validSplits++;
        }
        return validSplits;
    }
}