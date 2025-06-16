class Solution {
    public int maximumDifference(int[] nums) {
        int minYet = Integer.MAX_VALUE, maxYet = -1, ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minYet) {
                minYet = nums[i];
                maxYet = -1;
            }
            if (nums[i] > maxYet) {
                maxYet = nums[i];
                ans = Math.max(ans, maxYet - minYet);
            }
        }
        return ans == 0 ? -1 : ans;
    }
}