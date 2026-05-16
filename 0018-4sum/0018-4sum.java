class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // skip dup
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) // skip dup
                    continue;
                long twoSum = 0l + nums[i] + nums[j];
                for (int k = j + 1, l = n - 1; k < l;) { // 2 ptr
                    long sum = twoSum + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) // skip dup
                            k++;
                        while (k < l && nums[l] == nums[l + 1]) // skip dup
                            l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return ans;
    }
}