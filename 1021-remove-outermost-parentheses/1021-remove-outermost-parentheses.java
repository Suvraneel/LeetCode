class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length(), open = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (open++ > 0)
                    sb.append(c);
            } else {
                if (--open > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}