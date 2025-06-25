class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = 10001;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, INF);
        memo[0] = 0;
        for (int c : coins)
            for (int i = c; i <= amount; i++)
                memo[i] = Math.min(memo[i], memo[i - c] + 1);
        // System.out.println(Arrays.toString(memo));
        return memo[amount] == INF ? -1 : memo[amount];
    }
}