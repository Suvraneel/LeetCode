class Solution {
    public int rob(int[] nums) {
        int n = nums.length, prev = 0, curr = nums[0];
        for (int i = 1; i < n; i++){
            int temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
        }
        return curr;
    }
}