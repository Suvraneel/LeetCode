class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, lt = 0;
        for (int rt = 0; rt < n; rt++)
            if (nums[rt] != 0)
                nums[lt++] = nums[rt];
        while (lt < n)
            nums[lt++] = 0;
    }
}