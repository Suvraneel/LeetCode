class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, maxLen = 1, lt = 0, rt = 0, resBit = 0;
        for (; rt < n; rt++) {
            while ((resBit & nums[rt]) != 0)
                resBit ^= nums[lt++]; // shrink window
            resBit |= nums[rt]; // expand window
            maxLen = Math.max(maxLen, rt - lt + 1);
        }
        return maxLen;
    }
}