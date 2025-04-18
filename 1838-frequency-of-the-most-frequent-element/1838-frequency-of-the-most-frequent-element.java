class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, maxFreq = 1, next = n - 1;
        for (int i = next; i >= 0; i = next) {
            int elem = nums[i], j = i, rem = k;
            for (; j >= 0 && nums[j] == elem; j--)
                next = j - 1;
            for (; j >= 0 && rem >= elem - nums[j]; j--)
                rem -= elem - nums[j];
            maxFreq = Math.max(maxFreq, i - j);
        }
        return maxFreq;
    }
}