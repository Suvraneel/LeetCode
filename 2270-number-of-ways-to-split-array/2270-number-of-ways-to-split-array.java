class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, sum = 0, validSplits = 0;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n - 1; i++)
            if (nums[i] >= nums[n - 1] - nums[i])
                validSplits++;
        return validSplits;
    }
}