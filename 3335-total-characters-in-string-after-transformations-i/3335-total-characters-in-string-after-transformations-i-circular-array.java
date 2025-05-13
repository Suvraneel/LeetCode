class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int MOD = 1_000_000_007, len = s.length(), Zs = 25, Bs = 0;
        // idx ptrs for chars Z and B (B=0 bcz prev A contributes to B, prev B contributes to C instead)
        for (int i = 0; i < t; i++) {
            len = (len + freq[Zs]) % MOD;
            freq[Bs] = (freq[Bs] + freq[Zs]) % MOD; // so init with freq('a'), then add 'z' contribution 
            Zs = (26 + Zs - 1) % 26; // left shift Z ptr circularly, to simulate A->B, B->C & so on.
            Bs = (Zs + 1) % 26; // the char right after Z contributes to B
        }
        return len;
    }
}