class Solution {
public:
    int res = 0, start_i, start_j, box = 1;
    
    bool isInvalid(vector<vector<int>>& grid, int i, int j){
        return (i<0 || j<0 || i>=grid.size() || j>=grid[i].size());
    }
    
    void dfs(vector<vector<int>> grid, int i, int j, int ct=0){
        if(isInvalid(grid, i, j) || grid[i][j]==-1)
            return;
        if(grid[i][j]==2){
            if(ct==box)
                res++;
            return;
        }
        grid[i][j] = -1;
        dfs(grid, i, j+1, ct+1);
        dfs(grid, i, j-1, ct+1);
        dfs(grid, i+1, j, ct+1);
        dfs(grid, i-1, j, ct+1);
        grid[i][j] = 0;
    }
    
    int uniquePathsIII(vector<vector<int>>& grid) {
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[i].size(); j++){
                if(grid[i][j]==1)
                    start_i = i, start_j = j;
                else if(!grid[i][j]) box++;
            }
        }
        dfs(grid, start_i, start_j);
        return res;
    }
};