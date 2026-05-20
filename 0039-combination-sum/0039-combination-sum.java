class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(new ArrayList<>(), candidates, 0, 0, target);
        return ans;
    }

    void solve(List<Integer> curr, int[] cand, int idx, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target)
            return;
        for (int i = idx; i < cand.length; i++) {
            curr.add(cand[i]);
            solve(curr, cand, i, sum + cand[i], target);
            curr.remove(curr.size() - 1);
        }
    }
}