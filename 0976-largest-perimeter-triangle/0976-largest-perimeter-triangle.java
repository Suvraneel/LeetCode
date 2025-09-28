class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                int k = j - 1;
                while (k >= 0 && nums[i] < nums[j] + nums[k] && nums[k] != 0)
                    return nums[i] + nums[j] + nums[k--];
            }
        }
        return 0;
    }
}