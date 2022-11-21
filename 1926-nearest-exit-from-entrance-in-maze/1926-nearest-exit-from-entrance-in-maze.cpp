class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int res = 1;
        queue <pair<int, int>> q;
        q.push({entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]]='+';
        vector <pair<int, int>> offset = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.empty()){
            int sz = q.size();
            while(sz--){
                auto [x,y] = q.front();
                q.pop();
                for(int dir=0; dir<4; dir++){
                    int i = x+offset[dir].first, j = y+offset[dir].second;
                    if (i<0 || j<0 || i>=maze.size() || j>=maze[0].size() || maze[i][j]=='+')   // blocked
                        continue;
                    else if(i==0 || j==0 || i==maze.size()-1 || j==maze[0].size()-1)     // reached exit?
                        return res;
                    maze[i][j] = '+';   // visited
                    q.push({i, j});
                }
            }
            res++;
        }
        return -1;
    }
};