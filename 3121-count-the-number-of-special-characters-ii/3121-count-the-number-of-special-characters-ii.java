class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : word.toCharArray()) {
            if (c < 'a')
                upper[c - 'A'] = true;
            else {
                lower[c - 'a'] = !upper[c - 'a'];
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