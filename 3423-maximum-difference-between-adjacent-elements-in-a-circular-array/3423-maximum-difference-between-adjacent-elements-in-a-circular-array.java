class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length, dist = Math.abs(nums[n - 1] - nums[0]);
        for (int i = 1; i < n; i++)
            dist = Math.max(dist, Math.abs(nums[i] - nums[i - 1]));
        return dist;
    }
}