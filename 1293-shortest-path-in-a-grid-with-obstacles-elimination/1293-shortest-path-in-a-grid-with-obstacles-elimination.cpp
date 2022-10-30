// class Solution {
// public:
//     int solve(vector<vector<int>>& grid,int k){
// 		// At a particular cell we will store the number of obstacles that we can still remove after walking through that cell
//         vector<vector<int>> vis(grid.size(),vector<int>(grid[0].size(),-1));
//         queue<vector<int>> q;
		
// 		// queue stores (x,y,current path length,number of obstacles we can still remove)
//         q.push({0,0,0,k});
//         while(!q.empty()){
//             auto t=q.front();
//             int x=t[0],y=t[1];
//             q.pop();
			
// 			// Exit if current position is outside of the grid
//             if(x<0 || y<0 || x>=grid.size() || y>=grid[0].size()){
//                 continue;
//             }
			
// 			// Destination found
//             if(x==grid.size()-1 && y==grid[0].size()-1)
//                 return t[2];

//             if(grid[x][y]==1){
//                 if(t[3]>0) // If we encounter an obstacle and we can remove it
//                     t[3]--;
//                 else
//                     continue;
//             }
			
// 			// The cell was previously visited by some path and we were able to remove more obstacles from the previous path.
// 			// Then we don't need to continue on our current path
//             if(vis[x][y]!=-1 && vis[x][y]>=t[3])
//                 continue;
//             vis[x][y]=t[3];
            
//             q.push({x+1,y,t[2]+1,t[3]});
//             q.push({x,y+1,t[2]+1,t[3]});
//             q.push({x-1,y,t[2]+1,t[3]});
//             q.push({x,y-1,t[2]+1,t[3]});
            
//         }
//         return -1;
//     }
    
//     int shortestPath(vector<vector<int>>& grid, int k) {
//         return solve(grid,k);
//     }
// };


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