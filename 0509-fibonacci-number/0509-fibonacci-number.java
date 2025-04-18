class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return solve(n, memo);
    }

    private int solve(int n, int[] memo) {
        if (n <= 1)
            return n;
        if (memo[n] != 0)
            return memo[n];
        return memo[n] = solve(n - 2, memo) + solve(n - 1, memo);
    }
}