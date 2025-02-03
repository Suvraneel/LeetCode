class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int longestInc = 0, longestDec = 0, incStreak = 1, decStreak = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1])
                incStreak++;
            else
                incStreak = 1;
            longestInc = Math.max(longestInc, incStreak);
            if (nums[i] < nums[i - 1])
                decStreak++;
            else
                decStreak = 1;
            longestDec = Math.max(longestDec, decStreak);
        }
        return Math.max(longestInc, longestDec);
    }
}