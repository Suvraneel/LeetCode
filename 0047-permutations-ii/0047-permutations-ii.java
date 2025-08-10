class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        dfs(ans, freq, new LinkedList<>(), n);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, Map<Integer, Integer> freq, List<Integer> curr, int n) {
        if(curr.size() == n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(Map.Entry<Integer, Integer> e: freq.entrySet()){
            int k = e.getKey(), ct = e.getValue();
            if(ct == 0)
                continue;
            freq.put(k, ct - 1);
            curr.add(k);
            dfs(ans, freq, curr, n);
            freq.put(k, ct);
            curr.removeLast();
        }
    }
}