class Solution {
    int n;

    public int rob(int[] nums) {
        this.n = nums.length;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 0; i < n - 1; i++)
            memo[i + 2] = Math.max(memo[i] + nums[i + 1], memo[i + 1]);
        return memo[n];
    }
}