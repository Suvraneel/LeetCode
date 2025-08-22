class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length, top = m, btm = -1, lt = n, rt = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    btm = Math.max(btm, i);
                    lt = Math.min(lt, j);
                    rt = Math.max(rt, j);
                }
            }
        }
        // System.out.println(top + "\t" + btm + "\t" + lt + "\t" + rt);
        return (btm - top + 1) * (rt - lt + 1);
    }
}