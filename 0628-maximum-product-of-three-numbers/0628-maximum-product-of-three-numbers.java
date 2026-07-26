class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = Integer.MIN_VALUE;
        for (int i = n - 3; i <= n; i++)
            ans = Math.max(ans, nums[i % n] * nums[(i + 1) % n] * nums[(i + 2) % n]);
        return ans;
    }
}