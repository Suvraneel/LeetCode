class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, a = 0, b = 0, sum = 0;
        boolean[] vis = new boolean[n * n + 1];
        for (int[] r : grid) {
            for (int c : r) {
                if (vis[c])
                    a = c;
                vis[c] = true;
                sum += c;
            }
        }
        b = n * n * (n * n + 1) / 2 - sum + a;
        return new int[] { a, b };
    }
}