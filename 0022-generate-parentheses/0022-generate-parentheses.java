class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve("", 0, 0, n);
        return ans;
    }

    void solve(String s, int lt, int rt, int n) {
        if (s.length() == 2 * n)
            ans.add(s);
        if (lt < n)
            solve(s + "(", lt + 1, rt, n);
        if (rt < lt)
            solve(s + ")", lt, rt + 1, n);
    }
}