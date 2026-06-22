class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray())
            freq[c - 'a']++;
        // balloon = 1b,1a,2l,2o,1n
        return Math.min(Math.min(Math.min(freq['b' - 'a'], freq['a' - 'a']),
                Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2)),
                freq['n' - 'a']);
    }
}