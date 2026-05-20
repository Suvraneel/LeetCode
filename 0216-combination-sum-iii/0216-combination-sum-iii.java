class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(k, n, new ArrayList<>(), 1);
        return ans;
    }

    void solve(int k, int n, List<Integer> curr, int digit) {
        if (curr.size() == k) {
            if (n == 0)
                ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = digit; i < 10; i++) {
            if (n - i < 0)
                break;
            curr.add(i);
            solve(k, n - i, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}