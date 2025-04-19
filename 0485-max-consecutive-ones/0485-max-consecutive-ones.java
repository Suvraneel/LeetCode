class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, streak = 0, maxStreak = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                streak++;
            else {
                maxStreak = Math.max(maxStreak, streak);
                streak = 0;
            }
        }
        return Math.max(maxStreak, streak);
    }
}