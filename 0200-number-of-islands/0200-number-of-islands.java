class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    visitIsland(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void visitIsland(char[][] grid, int m, int n, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        visitIsland(grid, m, n, i+1, j);
        visitIsland(grid, m, n, i-1, j);
        visitIsland(grid, m, n, i, j+1);
        visitIsland(grid, m, n, i, j-1);
    }
}