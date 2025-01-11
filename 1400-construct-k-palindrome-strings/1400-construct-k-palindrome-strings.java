class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length())
            return false;
        if (k == s.length())
            return true;
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int odd = 0;
        for (int i = 0; i < 26; i++)
            if (freq[i] % 2 == 1)
                odd++;
        return k >= odd;
    }
}