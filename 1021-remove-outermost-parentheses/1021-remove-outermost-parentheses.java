class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length(), count = 0, open = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            count++;
            if (c == '(') {
                open++;
            } else {
                if (--open == 0) {
                    cs[i + 1 - count] = '.';
                    cs[i] = '.';
                    count = 0;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (cs[i] != '.')
                ans.append(cs[i]);
        return ans.toString();
    }
}