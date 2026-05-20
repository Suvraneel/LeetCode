class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(new StringBuilder(), 0, 0, n);
        return ans;
    }

    void solve(StringBuilder sb, int lt, int rt, int n) {
        if (sb.length() == 2 * n)
            ans.add(sb.toString());
        if (lt < n) {
            sb.append("(");
            solve(sb, lt + 1, rt, n);
            sb.setLength(sb.length() - 1);
        }
        if (rt < lt) {
            sb.append(")");
            solve(sb, lt, rt + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}