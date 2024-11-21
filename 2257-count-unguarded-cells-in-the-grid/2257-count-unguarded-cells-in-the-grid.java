class Solution {
    private long getId(int m, int n, int i, int j){
        return n*i + j;
    }
    private static int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<Long> vis = new HashSet<>();
        int[][] grid = new int[m][n];
        for(int[] w: walls){
            grid[w[0]][w[1]] = 1;
            vis.add(getId(m, n, w[0], w[1]));
        }
        for(int[] g: guards){
            grid[g[0]][g[1]] = 1;
            vis.add(getId(m, n, g[0], g[1]));
        }
        for(int[] g: guards){
            for(int[] d: dir){
                for(int i=g[0]+d[0], j=g[1]+d[1]; i>=0 && i<m && j>=0 && j<n && grid[i][j] != 1; i+=d[0], j+=d[1])
                    vis.add(getId(m, n, i, j));
            }
        }
        // System.out.println(vis);
        return m*n - vis.size();
    }
}