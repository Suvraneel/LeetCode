class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, maxOr = 0, totalSubsets = 1 << n, ans = 0;
        for (int i : nums)
            maxOr |= i;
        for (int bitMask = 0; bitMask < totalSubsets; bitMask++) {
            int or = 0;
            for (int i = 0; i < n; i++)
                if (((bitMask >> i) & 1) == 1)
                    or |= nums[i];
            if (or == maxOr)
                ans++;
        }
        return ans;
    }
}