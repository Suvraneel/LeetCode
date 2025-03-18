class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, maxLen = 1, lt = 0, rt = 0;
        for (; rt < n; rt++) {
            for (int i = lt; i < rt; i++) {
                if ((nums[i] & nums[rt]) != 0)
                    lt = i + 1;
            }
            maxLen = Math.max(maxLen, rt - lt + 1);
        }
        return maxLen;
    }
}