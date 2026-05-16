class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // skip dup
                continue;
            for (int j = i + 1, k = n - 1; j < k;) { // 2 ptr
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) // skip dup
                        j++;
                    while (j < k && nums[k] == nums[k + 1]) // skip dup
                        k--;
                } else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
}