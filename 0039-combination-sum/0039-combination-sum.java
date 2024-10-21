class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    private void solve(int[] candidates, int idx, int remainder, List<Integer> combination) {
        if (remainder == 0)
            ans.add(combination);
        for (int i = idx; i < candidates.length; i++) {
            if (remainder - candidates[i] < 0)
                return;
            List<Integer> newList = new ArrayList<>(combination);
            newList.add(candidates[i]);
            solve(candidates, i, remainder - candidates[i], newList);
        }
    }
}