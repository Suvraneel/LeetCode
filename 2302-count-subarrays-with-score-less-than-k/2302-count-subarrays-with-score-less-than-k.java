class Solution {
    public long countSubarrays(int[] nums, long k) {
        // (prefix2 - prefix1) * (i2 - i1) < k
        int n = nums.length;
        long prefixSum = 0, ans = 0;
        for (int lt = 0, rt = 0; rt < n; rt++) {
            prefixSum += nums[rt];
            while (lt <= rt && prefixSum * (rt - lt + 1) >= k)
                prefixSum -= nums[lt++];
            ans += rt - lt + 1;
        }
        return ans;
    }
}