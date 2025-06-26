class Solution {
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n), INF = 10001;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, INF);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 1; i <= sqrt; i++)
            for (int j = i * i; j <= n; j++)
                memo[j] = Math.min(memo[j], memo[j - i * i] + 1);
        // System.out.println(Arrays.toString(memo));
        return memo[n];
    }
}