class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int n : nums)
            maxOR |= n;
        return count(nums, maxOR, 0, 0);
    }

    private int count(int[] nums, int maxOR, int idx, int curOR) {
        if (idx == nums.length)
            return curOR == maxOR ? 1 : 0;
        return count(nums, maxOR, idx + 1, nums[idx] | curOR) + count(nums, maxOR, idx + 1, curOR);
    }
}