class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long len = s.length();
        long[] freq = new long[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int Zs = 25, Bs = 0;
        for (int i = 0; i < t; i++) {
            len = (len + freq[Zs]) % MOD;
            freq[Bs] = (freq[Bs] + freq[Zs]) % MOD;
            Zs = (26 + Zs - 1) % 26;
            Bs = (Zs + 1) % 26;
        }
        return (int) len;
    }
}