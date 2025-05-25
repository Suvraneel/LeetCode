class Solution {
    public int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];
        for (String w : words)
            freq[w.charAt(0) - 'a'][w.charAt(1) - 'a']++;
        int usedWords = 0, unusedPals = 0;
        for (int i = 0; i < 26; i++) {
            // System.out.println((char)('a'+i)+Arrays.toString(freq[i]));
            usedWords += (int) (freq[i][i] / 2) * 2;
            unusedPals += freq[i][i] % 2;
            freq[i][i] = 0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                usedWords += Math.min(freq[i][j], freq[j][i]);
            }
        }
        if (unusedPals > 0)
            usedWords++;
        return usedWords * 2;
    }
}