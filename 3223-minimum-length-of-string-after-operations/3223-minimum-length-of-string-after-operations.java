class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int n = s.length(), minLen = 0;
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        for (int i: freq)
            if(i>0)
                minLen += (i & 1) == 1 ? 1 : 2;
        return minLen;
    }
}