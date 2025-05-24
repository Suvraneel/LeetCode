class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        int n = words.length;
        String seq = String.valueOf(x);
        for (int i = 0; i < n; i++)
            if (words[i].contains(seq))
                ans.add(i);
        return ans;
    }
}