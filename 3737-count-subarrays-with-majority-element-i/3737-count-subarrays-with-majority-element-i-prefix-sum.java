class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, ans = 0, cumsum = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                cumsum++;
            prefixSum[i + 1] = cumsum;
        }
        for (int i = 0; i <= n; i++)
            for (int j = i + 1; j <= n; j++)
                if (prefixSum[j] - prefixSum[i] > (j - i) / 2f)
                    ans++;
        return ans;
    }
}