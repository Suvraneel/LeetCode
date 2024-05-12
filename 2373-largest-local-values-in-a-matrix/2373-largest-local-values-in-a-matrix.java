class Solution {
    public int solve(int[][] grid, int x, int y){
        int maxLocal = 0;
        for(int i=x-1; i<=x+1; i++)
            for(int j=y-1; j<=y+1; j++)
                maxLocal = Math.max(maxLocal, grid[i][j]);
        return maxLocal;
    }
    public int[][] largestLocal(int[][] grid) {
        int k = grid.length-2;
        int[][] ans = new int[k][k];
        for(int i=0; i<k; i++)
            for(int j=0; j<k; j++)
                ans[i][j] = solve(grid, i+1, j+1);
        return ans;
    }
}