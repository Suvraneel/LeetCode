class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxMonotonicLen = 1, incStreak = 1, decStreak = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incStreak++;
                decStreak = 1;
            } else if (nums[i] < nums[i - 1]) {
                decStreak++;
                incStreak = 1;
            } else
                incStreak = decStreak = 1;
            maxMonotonicLen = Math.max(maxMonotonicLen, Math.max(incStreak, decStreak));
        }
        return maxMonotonicLen;
    }
}