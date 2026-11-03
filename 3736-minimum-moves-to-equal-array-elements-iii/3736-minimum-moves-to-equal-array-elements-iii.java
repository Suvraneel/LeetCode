class Solution {
    public int minMoves(int[] nums) {
        int maxm = 0, ans = 0, n = nums.length;
        for (int i = 0; i < n; i++)
            maxm = Math.max(maxm, nums[i]);
        for (int i = 0; i < n; i++)
            ans += maxm - nums[i];
        return ans;
    }
}