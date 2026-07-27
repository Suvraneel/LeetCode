class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b)
                b = nums[i];
        }
        return (a - 1) * (b - 1);
    }
}