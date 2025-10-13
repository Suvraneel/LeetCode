class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
            if (ans.isEmpty() || !areAnagrams(words[i], ans.get(ans.size() - 1)))
                ans.add(words[i]);
        return ans;
    }

    private boolean areAnagrams(String w1, String w2) {
        int n = w1.length();
        if (n != w2.length())
            return false;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[w1.charAt(i) - 'a']++;
            freq[w2.charAt(i) - 'a']--;
        }
        return Arrays.stream(freq).allMatch(c -> c == 0);
    }
}