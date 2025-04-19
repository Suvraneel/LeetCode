class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, count = 0, lt = 0, rt = 0, prev = -101;
        while (rt < n)
            if (nums[rt] == prev)
                rt++;
            else {
                prev = nums[rt];
                nums[lt++] = nums[rt++];
            }
        return lt;
    }
}