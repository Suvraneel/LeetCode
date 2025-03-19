class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, lt = 0, rt = 2, flips = 0;
        while (rt < n) {
            if (nums[lt] == 0) {
                nums[lt] = 1;
                nums[lt + 1] = 1 - nums[lt + 1];
                nums[rt] = 1 - nums[rt];
                flips++;
            }
            lt++;
            rt++;
        }
        return ((nums[rt - 1] & nums[rt - 2]) & nums[rt - 3]) == 0 ? -1 : flips;
    }
}