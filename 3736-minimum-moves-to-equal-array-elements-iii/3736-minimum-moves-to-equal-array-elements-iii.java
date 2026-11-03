class Solution {
    public int minMoves(int[] nums) {
        int maxm = 0, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            maxm = Math.max(maxm, nums[i]);
            sum += nums[i];
        }
        return maxm * n - sum;
    }
}