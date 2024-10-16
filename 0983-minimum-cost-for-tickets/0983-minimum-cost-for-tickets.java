class Solution {
    int[] days, costs, memo;
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.n = days.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(0);
    }

    private int solve(int idx) {
        if (idx >= n)
            return 0;
        if (memo[idx] != -1)
            return memo[idx];
        int i = idx, date = days[idx++];
        int pass1 = costs[0] + solve(idx);
        while (idx < n && date + 7 > days[idx])
            idx++;
        int pass2 = costs[1] + solve(idx);
        while (idx < n && date + 30 > days[idx])
            idx++;
        int pass3 = costs[2] + solve(idx);
        return memo[i] = Math.min(pass1, Math.min(pass2, pass3));
    }
}