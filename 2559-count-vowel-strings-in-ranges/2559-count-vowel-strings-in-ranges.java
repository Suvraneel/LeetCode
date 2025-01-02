class Solution {
    private static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowelFlankedWords = new int[words.length], ans = new int[queries.length];
        int prefixSum = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            vowelFlankedWords[i] = prefixSum;
            if (vowels.contains(s.charAt(0))
                    && vowels.contains(s.charAt(s.length() - 1)))
                prefixSum = vowelFlankedWords[i] += 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            ans[i] = q[0] == 0 ? vowelFlankedWords[q[1]] : vowelFlankedWords[q[1]] - vowelFlankedWords[q[0] - 1];
        }
        return ans;
    }
}