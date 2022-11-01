class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> res;
        for(int i=0; i<grid[0].size(); i++){
            pair<int, int> curr = {0, i};
            bool stuck = false;
            while(!stuck && curr.first<grid.size()-1){
                int currVal = grid[curr.first][curr.second];
                if(curr.second+currVal<grid[0].size() && curr.second+currVal>=0 && currVal*grid[curr.first][curr.second+currVal]==1)
                    curr.first++, curr.second+=currVal;
                else stuck = true;
                // cout << "(" << curr.first << "," << curr.second << ")\n";
            }
            // cout << "---" << endl;
            int currVal = grid[curr.first][curr.second];
            res.push_back(stuck || curr.second+currVal>=grid[0].size() || curr.second+currVal<0 || currVal*grid[curr.first][curr.second+currVal]!=1?-1:curr.second+grid[curr.first][curr.second]);
        }
        return res;
    }
};