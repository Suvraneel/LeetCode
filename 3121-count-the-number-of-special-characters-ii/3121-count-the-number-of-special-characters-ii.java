class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c < 'a')
                upper[c - 'A'] = true;
            else {
                if (upper[c - 'a'])
                    lower[c - 'a'] = false;
                else
                    lower[c - 'a'] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i])
                count++;
        }
        return count;
    }
}