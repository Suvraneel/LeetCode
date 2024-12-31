class Solution {
    int[] passes = { 1, 7, 30 };

    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length + 1];
        return solve(days, costs, 0, memo);
    }

    private int solve(int[] days, int[] costs, int dayIdx, int[] memo) {
        if (dayIdx == days.length)
            return 0;
        if (memo[dayIdx] != 0)
            return memo[dayIdx];
        int $ = Integer.MAX_VALUE, idx = dayIdx + 1;
        for (int i = 0; i < 3; i++) {
            while (idx < days.length && days[idx] < days[dayIdx] + passes[i])
                idx++;
            $ = Math.min($, costs[i] + solve(days, costs, idx, memo));
        }
        return memo[dayIdx] = $;
    }
}