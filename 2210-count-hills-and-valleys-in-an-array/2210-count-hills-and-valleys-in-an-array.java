class Solution {
    public int countHillValley(int[] nums) {
        int prev = nums[0], ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] > prev && nums[i] > nums[i + 1]) || nums[i] < prev && nums[i] < nums[i + 1]) {
                ans++;
                // System.out.println(nums[i] + "\t" + ans);
            }
            if (nums[i] == nums[i + 1])
                continue;
            prev = nums[i];
        }
        return ans;
    }
}