class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int k = i + 1; k < n; k++) {
                if (set.contains(-(nums[i] + nums[k]))) {
                    List<Integer> l = Arrays.asList(nums[i], -(nums[i] + nums[k]), nums[k]);
                    l.sort(null);
                    ans.add(l);
                }
                set.add(nums[k]);
            }
        }
        return new ArrayList<>(ans);
    }
}