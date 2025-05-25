class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = map.getOrDefault(-(nums[i] + nums[j]), 0);
                if (k > j)
                    ans.add(List.of(nums[i], nums[j], nums[k]));
            }
        }
        return ans;
    }
}