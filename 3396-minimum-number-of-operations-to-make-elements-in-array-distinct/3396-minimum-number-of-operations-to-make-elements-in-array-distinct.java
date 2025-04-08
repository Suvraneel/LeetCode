class Solution {
    public int minimumOperations(int[] nums) {
        int[] seen = new int[101]; // constraint says 1 <= nums[i] <= 100
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (seen[nums[i]] == 1)
                return (int) Math.ceil((i + 1) / 3.0);
            seen[nums[i]]++;
        }
        return 0;
    }
}