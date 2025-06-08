class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++)
            solve(i, n);
        return ans;
    }

    private void solve(int base, int n) {
        if (base > n)
            return;
        ans.add(base);
        for (int i = 0; i < 10; i++)
            solve(base * 10 + i, n);
    }
}