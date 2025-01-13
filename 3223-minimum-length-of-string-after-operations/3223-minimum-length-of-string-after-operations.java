class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int n = s.length(), minLen = 0;
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        for (int i = 0; i < 26; i++)
            minLen += freq[i] == 0 ? 0 : freq[i] % 2 == 1 ? 1 : 2;
        return minLen;
    }
}