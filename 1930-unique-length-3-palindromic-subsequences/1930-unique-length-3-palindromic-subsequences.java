class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length(), ans = 0;
        int[] firstIdx = new int[26], lastIdx = new int[26];
        Arrays.fill(firstIdx, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (firstIdx[c] == -1)
                firstIdx[c] = i;
            else
                lastIdx[c] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (firstIdx[i] != -1 && firstIdx[i] != lastIdx[i]) {
                Set<Character> middleChar = new HashSet<>();
                for (int j = firstIdx[i] + 1; j < lastIdx[i]; j++)
                    middleChar.add(s.charAt(j));
                ans += middleChar.size();
            }
        }
        return ans;
    }
}