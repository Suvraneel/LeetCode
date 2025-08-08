class Solution {
    private int[][] servings = { { 4, 0 }, { 3, 1 }, { 2, 2 }, { 1, 3 } };

    public double soupServings(int n) {
        n = (int) Math.ceil(n / 25.0);
        Map<Pair<Integer, Integer>, Double> dp = new HashMap<>();
        for (int k = 1; k <= n; k++)
            if (dfs(k, k, dp) > 1 - 1e-5)   // optimized early return as constraint reaches limit precision 10^-5
                return 1.0;
        return dfs(n, n, dp);
    }

    private double dfs(int a, int b, Map<Pair<Integer, Integer>, Double> dp) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1d;
        if (b <= 0)
            return 0d;
        Pair<Integer, Integer> key = new Pair<>(a, b);
        if (dp.containsKey(key))
            return dp.get(key);
        double res = 0;
        for (int[] s : servings)
            res += dfs(a - s[0], b - s[1], dp);
        res /= 4d;
        dp.put(key, res);
        return res;
    }
}