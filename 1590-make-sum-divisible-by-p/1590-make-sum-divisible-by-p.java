class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n;
        nums[0] %= p;
        for (int i = 1; i < n; i++)
            nums[i] = (nums[i] + nums[i - 1]) % p;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                ans = Math.min(n - 1 - i, ans);
            for (int j = i + 1; j < n; j++)
                if (nums[i] == nums[j])
                    ans = Math.min(j - 1 - i, ans);
        }
        return ans == n ? -1 : ans;
    }
}