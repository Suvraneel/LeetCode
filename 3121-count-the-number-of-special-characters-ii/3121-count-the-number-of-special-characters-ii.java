class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
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