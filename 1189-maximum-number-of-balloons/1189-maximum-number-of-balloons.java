class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray())
            freq[c - 'a']++;
        // balloon = 1b,1a,2l,2o,1n
        int ans = Math.min(freq['b' - 'a'], freq['a' - 'a']);
        ans = Math.min(ans, freq['l' - 'a'] / 2);
        ans = Math.min(ans, freq['o' - 'a'] / 2);
        ans = Math.min(ans, freq['n' - 'a']);
        return ans;
    }
}