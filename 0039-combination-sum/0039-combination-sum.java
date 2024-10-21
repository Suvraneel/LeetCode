class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int idx, int remainder, List<Integer> combination, List<List<Integer>> ans) {
        if (remainder <= 0) {
            if (remainder == 0)
                ans.add(combination);
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<>(combination);
            newList.add(candidates[i]);
            backtrack(candidates, i, remainder - candidates[i], newList, ans);
        }
    }
}