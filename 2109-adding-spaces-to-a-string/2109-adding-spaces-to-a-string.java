class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] cs = s.toCharArray();
        char[] ans = new char[cs.length + spaces.length];
        int i = 0, j = 0;
        for (; i < ans.length && j < spaces.length; i++) {
            if (i - j == spaces[j]) {
                ans[i] = ' ';
                j++;
            } else
                ans[i] = cs[i - j];
        }
        for (; i < ans.length; i++)
            ans[i] = cs[i - j];
        return new String(ans);
    }
}