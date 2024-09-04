class Solution {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < Math.min(n + 1, 3); i++)
            memo[i] = i;
        for (int i = 3; i <= n; i++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }
}