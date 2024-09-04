class Solution {
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return solve(n);
    }

    private int solve(int n) {
        if (n < 3)
            return n;
        if (memo[n] != 0)
            return memo[n];
        return memo[n] = solve(n - 1) + solve(n - 2);
    }
}