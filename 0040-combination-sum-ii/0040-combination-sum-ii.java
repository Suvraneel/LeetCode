class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(
        List<List<Integer>> answer,
        List<Integer> tempList,
        int[] candidates,
        int target,
        int ltIdx
    ) {
        if (target < 0) return; // Invalid combo
        else if (target == 0) { // Bingo !
            answer.add(new ArrayList<>(tempList));
        } else {
            for (
                int i = ltIdx;
                i < candidates.length && target >= candidates[i];
                i++
            ) {
                if (i > ltIdx && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                backtrack(
                    answer,
                    tempList,
                    candidates,
                    target - candidates[i],
                    i + 1
                );
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}