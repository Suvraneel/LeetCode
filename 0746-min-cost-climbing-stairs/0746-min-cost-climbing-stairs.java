class Solution {
    int INF = Integer.MAX_VALUE;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] targetCost = new int[n];
        Arrays.fill(targetCost, INF);
        dfs(0, cost, targetCost);
        // System.out.println(Arrays.toString(targetCost));
        return Math.min(targetCost[0], targetCost[1]);
    }

    private int dfs(int i, int[] cost, int[] targetCost) {
        if (i >= cost.length)
            return 0;
        if (targetCost[i] != INF)
            return targetCost[i];
        return targetCost[i] = cost[i] + Math.min(dfs(i + 1, cost, targetCost), dfs(i + 2, cost, targetCost));
    }
}