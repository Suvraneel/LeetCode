class Solution {
    int[] nums;
    int n, maxOr;
    int[][] memo;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        maxOr = 0;
        for (int i : nums)
            maxOr |= i;
        this.memo = new int[n + 1][maxOr + 1];
        for (int[] idx : memo)
            Arrays.fill(idx, -1);
        return solve(0, 0);
    }

    private int solve(int idx, int or) {
        if (idx == n)
            return maxOr == or ? 1 : 0;
        if (memo[idx][or] != -1)
            return memo[idx][or];
        // System.out.println(idx + "\t" + or);
        return memo[idx][or] = solve(idx + 1, or | nums[idx]) + solve(idx + 1, or);
    }
}