class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++)
            solve(String.valueOf(i), n);
        return ans;
    }

    private void solve(String base, int n) {
        int val = Integer.parseInt(base);
        if (val > n)
            return;
        ans.add(val);
        for (int i = 0; i < 10; i++)
            solve(base + i, n);
    }
}