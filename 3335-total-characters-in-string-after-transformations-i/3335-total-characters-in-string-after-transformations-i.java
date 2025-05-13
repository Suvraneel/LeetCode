class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] freq = new long[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        while (t-- > 0) {
            long temp = freq[25];
            freq[25] = 0;
            for (int i = 24; i >= 0; i--) {
                freq[i + 1] = freq[i];
                freq[i] = 0;
            }
            freq[0] = temp;
            freq[1] = (freq[1] + temp) % MOD;
        }
        long len = 0;
        for (long f : freq)
            len = (len + f) % MOD;
        return (int) len;
    }
}