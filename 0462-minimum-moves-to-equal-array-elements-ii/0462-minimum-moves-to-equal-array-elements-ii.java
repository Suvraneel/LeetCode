class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        int median = (n & 1) == 1 ? nums[n / 2] : (nums[n / 2 - 1] + nums[n / 2]) / 2;
        for (int i : nums)
            ans += Math.abs(median - i);
        return ans;
    }
}