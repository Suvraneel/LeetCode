class Solution {
    int[] minCost;
    int INF = 1001;

    public int mincostTickets(int[] days, int[] costs) {
        minCost = new int[days[days.length - 1] + 1];
        Arrays.fill(minCost, INF);
        int[] pass = { 1, 7, 30 };
        Set<Integer> need = new HashSet<>();
        for (int d : days)
            need.add(d);
        dfs(need, days, costs, days[0]);
        return minCost[days[0]];
    }

    private int dfs(Set<Integer> need, int[] days, int[] costs, int day) {
        if (day > days[days.length - 1])
            return 0;
        if (!need.contains(day))
            return dfs(need, days, costs, day + 1);
        if (minCost[day] != INF)
            return minCost[day];
        minCost[day] = Math.min(dfs(need, days, costs, day + 1) + costs[0], Math.min(
                dfs(need, days, costs, day + 7) + costs[1], dfs(need, days, costs, day + 30) + costs[2]));
        return minCost[day];
    }
}