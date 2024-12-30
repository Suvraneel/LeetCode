class Solution {
    int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int goodStrings = 0;
        int memo[] = new int[high + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        for (int i = low; i <= high; i++)
            goodStrings = (goodStrings + solve(i, zero, one, memo)) % MOD;
        return goodStrings;
    }

    private int solve(int rem, int zero, int one, int[] memo) {
        if (memo[rem] != -1)
            return memo[rem];
        int goodStrings = 0;
        if (rem >= zero)
            goodStrings += solve(rem - zero, zero, one, memo);
        if (rem >= one)
            goodStrings += solve(rem - one, zero, one, memo);
        return memo[rem] = goodStrings % MOD;
    }
}