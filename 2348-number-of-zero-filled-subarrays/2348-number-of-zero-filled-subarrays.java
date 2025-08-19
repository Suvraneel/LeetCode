class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long streak = 0, count = 0;
        for (int i : nums) {
            if (i == 0)
                count += ++streak;
            else
                streak = 0;
        }
        return count;
    }
}