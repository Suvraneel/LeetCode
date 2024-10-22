class Solution {
    int[][] memo;

    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        this.memo = new int[amount + 1][coins.length + 1];
        for(int[] m: memo)
            Arrays.fill(m, -1);
        return backtrack(amount, 0, coins);
    }

    private int backtrack(int remainder, int idx, int[] coins) {
        if (remainder == 0)
            return 1;
        if (memo[remainder][idx] != -1)
            return memo[remainder][idx];
        int ways = 0;
        for (int i = idx; i < coins.length; i++) {
            if (remainder < coins[i])
                continue;
            ways += backtrack(remainder - coins[i], i, coins);
        }
        return memo[remainder][idx] = ways;
    }
}