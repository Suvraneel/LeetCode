class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[n - 1] = 0;
        dfs(nums, target, memo, 0);
        return memo[0] > 0 ? memo[0] : -1;
    }

    private int dfs(int[] nums, int target, int[] memo, int i) {
        if (memo[i] > Integer.MIN_VALUE)
            return memo[i];
        int maxJumps = Integer.MIN_VALUE;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target)
                maxJumps = Math.max(maxJumps, dfs(nums, target, memo, j) + 1);
        }
        // System.out.println(Arrays.toString(memo));
        return memo[i] = maxJumps;
    }
}