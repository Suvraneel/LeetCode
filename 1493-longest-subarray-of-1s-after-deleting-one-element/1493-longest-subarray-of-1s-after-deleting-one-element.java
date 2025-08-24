class Solution {
    public int longestSubarray(int[] nums) {
        int penUltStreak = 0, ultStreak = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                ultStreak++;
            else {
                ans = Math.max(ans, ultStreak + penUltStreak);
                penUltStreak = ultStreak;
                ultStreak = 0;
            }
        }
        ans = Math.max(ans, ultStreak + penUltStreak);
        return Math.min(ans, nums.length - 1); // edge case: if all 1s, atleast one elem must be deleted
    }
}