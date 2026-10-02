class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        solve(sb, 0, 0, n);
        return ans;
    }

    void solve(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n)
            ans.add(sb.toString());
        if (open < n) {
            sb.append("(");
            solve(sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            solve(sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}