class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length, prev = -1;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (groups[i] == prev)
                continue;
            prev = groups[i];
            ans.add(words[i]);
        }
        return ans;
    }
}