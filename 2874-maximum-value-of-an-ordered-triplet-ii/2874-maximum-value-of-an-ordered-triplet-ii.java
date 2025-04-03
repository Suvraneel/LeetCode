class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = nums[0];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            suffixMax[n - 1 - i] = Math.max(suffixMax[n - i], nums[n - 1 - i]);
        }
        long ans = 0;
        for (int i = 1; i < n - 1; i++)
            ans = Math.max(ans, (prefixMax[i - 1] - (long) nums[i]) * suffixMax[i + 1]);
        return ans;
    }
}