class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[] signs = new int[n];
        Arrays.fill(signs, -1);
        return solve(signs, nums, target, n, 0);
    }

    private int solve(int[] signs, int[] nums, int target, int n, int idx) {
        int ct = 0;
        for (int i = idx; i < n; i++) {
            signs[i] = 1;
            ct += solve(signs, nums, target, n, i + 1);
            signs[i] = -1;
        }
        for (int i = 0; i < n; i++)
            target -= nums[i] * signs[i];
        return target == 0 ? ++ct : ct;
    }
}