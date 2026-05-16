class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, streak = 1, ans = 0;
        if (n == 0)
            return 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] == nums[i])
                ;
            else if (nums[i + 1] - nums[i] == 1)
                streak++;
            else {
                ans = Math.max(ans, streak);
                streak = 1;
            }
        }
        return Math.max(ans, streak);
    }
}