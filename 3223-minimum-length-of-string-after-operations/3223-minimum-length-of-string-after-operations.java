class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int minLen = 0;
        for (byte c : s.getBytes())
            freq[c - 'a']++;
        for (int i: freq)
            if(i>0)
                minLen += 2 - (i & 1);
        return minLen;
    }
}