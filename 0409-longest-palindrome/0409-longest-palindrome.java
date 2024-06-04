class Solution {
    public int longestPalindrome(String s) {
        boolean[] freq = new boolean[58];
        int len = 0;
        char[] S = s.toCharArray();
        for (char c : S){
            if(freq[c-'A'])
                len += 2;
            freq[c-'A'] = !freq[c-'A'];
        }
        boolean single = false;
        for (char c : S)
            if(freq[c-'A'])
                return ++len;
        return len;
    }
}