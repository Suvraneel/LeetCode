class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length())
            return false;
        if (k == s.length())
            return true;
        int odd = 0;
        for (char c : s.toCharArray())
            odd ^= 1 << c - 'a';
        return k >= Integer.bitCount(odd);
    }
}