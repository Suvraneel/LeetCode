class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length, lt = 0, rt = 0;
        for (; rt < n; rt++) {
            if (nums[rt] == 0)
                continue;
            if (rt < n - 1 && nums[rt] == nums[rt + 1]) {
                nums[lt] = nums[rt] * 2;
                lt++;
                rt++;
            } else {
                nums[lt] = nums[rt];
                lt++;
            }
        }
        while (lt < n)
            nums[lt++] = 0;
        return nums;
    }
}