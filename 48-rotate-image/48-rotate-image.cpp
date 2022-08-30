class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        vector<vector<int>>v;
        vector<int> row;
        for(int i=0; i<matrix.size(); i++){
            row.clear();
            for (int j=0; j<matrix[0].size(); j++){
                row.push_back(matrix[i][j]);
            }
            v.push_back(row);
        }
        for(int i=0; i<v.size(); i++){
            for (int j=0; j<v[0].size(); j++){
                v[i][j] = matrix[j][i];
            }
        }
        for(int i=0; i<v.size(); i++){
            for (int j=0; j<v[0].size(); j++){
                matrix[i][j] = v[i][v[0].size()-1-j];
            }
        }
    }
};