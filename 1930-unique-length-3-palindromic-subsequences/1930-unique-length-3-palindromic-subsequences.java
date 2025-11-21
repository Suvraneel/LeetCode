class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26], last = new int[26];
        int n = s.length(), ans = 0;
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1)
                first[c] = i;
            last[c] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1)
                continue;
            Set<Character> set = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++)
                set.add(s.charAt(j));
            ans += set.size();
        }
        return ans;
    }
}