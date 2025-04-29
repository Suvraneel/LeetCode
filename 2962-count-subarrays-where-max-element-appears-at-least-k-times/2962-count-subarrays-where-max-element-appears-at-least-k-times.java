class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, maxm = 0, count = 0;
        long ans = 0;
        for (int i = 0; i < n; i++)
            maxm = Math.max(maxm, nums[i]);
        for (int lt = 0, rt = 0; rt < n; rt++) {
            if (nums[rt] == maxm)
                count++;
            while (count == k) {
                if (nums[lt] == maxm)
                    count--;
                lt++;
            }
            ans += lt;
        }
        return ans;
    }
}