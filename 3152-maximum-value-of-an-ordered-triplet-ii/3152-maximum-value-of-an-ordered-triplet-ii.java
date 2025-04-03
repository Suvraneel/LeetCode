class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length, maxm = 0, diffMax = 0;
        long ans = 0;
        for (int k = 0; k < n; k++) {
            ans = Math.max(ans, (long) diffMax * nums[k]);
            diffMax = Math.max(diffMax, maxm - nums[k]);
            maxm = Math.max(maxm, nums[k]);
        }
        return ans;
    }
}