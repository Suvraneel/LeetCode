class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            if (curr < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(curr, max * curr);
            min = Math.min(curr, min * curr);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}