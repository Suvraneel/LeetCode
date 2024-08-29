class Solution {
    int n;

    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        int maxBlast = 0;
        for (int i = 0; i < n; i++)
            maxBlast = Math.max(maxBlast, dfs(bombs, new boolean[n], i));
        return maxBlast;
    }

    int dfs(int[][] bombs, boolean[] vis, int curr) {
        int ct = 1;
        vis[curr] = true;
        for (int i = 0; i < n; i++)
            if (!vis[i] && Math.pow(bombs[curr][0] - bombs[i][0], 2) + Math.pow(bombs[curr][1] - bombs[i][1], 2) <= Math
                    .pow(bombs[curr][2], 2))
                ct += dfs(bombs, vis, i);
        return ct;
    }
}