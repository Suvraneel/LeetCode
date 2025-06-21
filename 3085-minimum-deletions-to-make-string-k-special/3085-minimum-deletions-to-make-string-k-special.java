class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray())
            freq[c - 'a']++;
        Arrays.sort(freq);
        int st = 0, prefixDel = 0, ans = word.length();
        while (freq[st] == 0)
            st++;
        for (int i = st; i < 26; i++) {
            int suffixDel = 0;
            for (int j = i + 1; j < 26; j++)
                suffixDel += Math.max(freq[j] - freq[i] - k, 0);
            ans = Math.min(ans, prefixDel + suffixDel);
            prefixDel += freq[i];
        }
        return ans;
    }
}