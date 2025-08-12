class Solution {
    int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        // Max term: n1^x=n  => xlogn1=logn => n1 = 10^(logn/x)
        int rt = (int) Math.ceil(Math.pow(10, Math.log10(n) / x));
        int memo[][] = new int[n + 1][rt + 1];
        return solve(n, x, rt, memo);
    }

    private int solve(int n, int x, int rt, int[][] memo) {
        if (n == 0)
            return 1; // 1 way
        else if (n < 0 || rt == 0)
            return 0; // invalid; backtrack
        if (memo[n][rt] != 0)
            return memo[n][rt];
        return memo[n][rt] = (solve(n - (int) Math.pow(rt, x), x, rt - 1, memo) + solve(n, x, rt - 1, memo)) % MOD;
    }
}