import java.util.Arrays;

class Solution {
    int MOD = 1_000_000_007, n, lt, rt, m;
    int[][][] memo;     // memo[dir][idx][val - lt]
    int[][][] prefix;   // prefix[dir][idx][t], t in [0, m]
    boolean[][] built;  // built[dir][idx]

    public int zigZagArrays(int n, int l, int r) {
        this.n = n;
        this.lt = l;
        this.rt = r;
        this.m = r - l + 1;

        memo = new int[2][n][m];
        for (int dir = 0; dir < 2; dir++)
            for (int idx = 0; idx < n; idx++)
                Arrays.fill(memo[dir][idx], -1);

        prefix = new int[2][n][m + 1];
        built = new boolean[2][n];

        int ans = 0;
        for (int val = lt; val <= rt; val++) {
            ans = (ans + solve(0, val, 1)) % MOD;
            ans = (ans + solve(0, val, 0)) % MOD;
        }
        return ans;
    }

    void ensurePrefix(int idx, int dir) {
        if (built[dir][idx]) return;
        int[] p = prefix[dir][idx];
        for (int val = lt; val <= rt; val++) {
            int v = solve(idx, val, dir);
            p[val - lt + 1] = (p[val - lt] + v) % MOD;
        }
        built[dir][idx] = true;
    }

    int solve(int idx, int val, int rising) {
        if (idx == n - 1)
            return 1;
        if (memo[rising][idx][val - lt] != -1)
            return memo[rising][idx][val - lt];

        int nextDir = rising ^ 1;
        ensurePrefix(idx + 1, nextDir);
        int[] p = prefix[nextDir][idx + 1];

        int ans;
        if (rising == 0) {
            ans = p[val - lt];
        } else {
            ans = (p[m] - p[val - lt + 1] + MOD) % MOD;
        }
        return memo[rising][idx][val - lt] = ans;
    }
}