class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray())
            freq[c - 'a']++;
        Arrays.sort(freq);
        int posn = 1, key = 2, ans = 0;
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            ans += posn;
            key++;
            if (key == 10) {
                key = 2;
                posn++;
            }
        }
        return ans;
    }
}