class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length - 1;
        for (int i : nums)
            ans += nums[n] - i;
        return ans;
    }
}