class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[101]; // constraint says 1 <= nums[i] <= 100
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (seen[nums[i]])
                return (int) Math.ceil((i + 1) / 3.0);
            seen[nums[i]] = true;
        }
        return 0;
    }
}