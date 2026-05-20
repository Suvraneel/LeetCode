class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    void solve(int[] nums, List<List<Integer>> ans, List<Integer> curr, int idx) {
        ans.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            curr.add(nums[i]);
            solve(nums, ans, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}