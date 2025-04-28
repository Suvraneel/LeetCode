class Solution {
    public long countSubarrays(int[] nums, long k) {
        // (prefix2 - prefix1) * (i2 - i1) < k
        long prefixSum = 0, ans = 0;
        for (int lt = 0, rt = 0; rt < nums.length; rt++) {
            prefixSum += nums[rt];
            while (lt <= rt && prefixSum * (rt - lt + 1) >= k)
                prefixSum -= nums[lt++];
            ans += rt - lt + 1;
        }
        return ans;
    }
}