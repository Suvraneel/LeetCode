class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length(), len = 0, val = 0,
                bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                len++;
            else if (len < bits) {
                int temp = val + (1 << len);
                if (temp <= k) {
                    val = temp;
                    len++;
                }
            }
        }
        return len;
    }
}