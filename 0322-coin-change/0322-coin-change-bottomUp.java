class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = 10001;
        Arrays.sort(coins);
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, INF);
        memo[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int c : coins) {
                if (i - c < 0)
                    break;
                memo[i] = Math.min(memo[i], memo[i - c] + 1);
            }
        }
        // System.out.println(Arrays.toString(memo));
        return memo[amount] == INF ? -1 : memo[amount];
    }
}