class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        vector<int> x(matrix[0].size(), 0);
        vector<vector<int>>v(matrix.size(), x);
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