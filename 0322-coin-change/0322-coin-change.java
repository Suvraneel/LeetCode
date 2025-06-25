class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length, INF = 10001;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, INF);
        memo[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int c = 0; c < n; c++)
                if (i - coins[c] >= 0)
                    memo[i] = Math.min(memo[i], memo[i - coins[c]] + 1);
        }
        // System.out.println(Arrays.toString(memo));
        return memo[amount] == INF ? -1 : memo[amount];
    }
}