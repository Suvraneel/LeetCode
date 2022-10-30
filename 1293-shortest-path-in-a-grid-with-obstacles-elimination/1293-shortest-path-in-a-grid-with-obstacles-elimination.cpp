class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        queue<vector<int>> q;   // x_coord, y_coord, dist_of_path, k_left
        vector<vector<int>> v(grid.size(), vector<int>(grid[0].size(), -1));  // visited
        q.push({0,0,0,k});
        while(!q.empty()){
            auto posn = q.front();
            int X = posn[0], Y=posn[1], D=posn[2], K=posn[3];
            q.pop();
            if(X<0||Y<0||X>=grid.size()||Y>=grid[0].size()) // valid?
                continue;
            if(X==grid.size()-1 && Y==grid[0].size()-1) // dest arrived?
                return D;
            if(grid[X][Y]){  // blocked? Find shortcut...
                if(K)   // moves left?
                    K--;
                else continue;
            }   
            // open space ....
            if(v[X][Y]!=-1 && v[X][Y]>=K) // visited already by removing lesser blockades?
                continue;
            else v[X][Y]=K;
            q.push({X+1,Y,D+1,K});
            q.push({X,Y+1,D+1,K});
            q.push({X-1,Y,D+1,K});
            q.push({X,Y-1,D+1,K});
        }
        return -1;
    }
};