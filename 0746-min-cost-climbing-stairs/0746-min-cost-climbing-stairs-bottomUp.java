class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = n - 3; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        // System.out.println(Arrays.toString(cost));
        return Math.min(cost[0], cost[1]);
    }
}