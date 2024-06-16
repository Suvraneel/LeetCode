class Solution {
    public int minPatches(int[] nums, int n) {
        int len = nums.length, res = 0, i = 0;
        long missing = 1;
        while (missing <= n) {
            if (i < len && nums[i] <= missing) {
                missing += nums[i++];
            } else {
                missing += missing;
                res++;
            }
        }
        return res;
    }
}