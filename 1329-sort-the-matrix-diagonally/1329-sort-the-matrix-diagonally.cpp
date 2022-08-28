class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        for(int row=0;row<mat.size(); row++){
            vector <int> v;
            for (int i=row, j=0; j<mat[0].size() && i<mat.size(); i++, j++){
                v.push_back(mat[i][j]);
            }
            sort(v.begin(), v.end());
            for (int i=row, j=0, c=0; j<mat[0].size() && i<mat.size(); i++, j++){
                mat[i][j] = v[c++];
            }
        }
        for(int col=0;col<mat[0].size(); col++){
            vector <int> v;
            for (int i=0, j=col; j<mat[0].size() && i<mat.size(); i++, j++){
                v.push_back(mat[i][j]);
            }
            sort(v.begin(), v.end());
            for (int i=0, j=col, c=0; j<mat[0].size() && i<mat.size(); i++, j++){
                mat[i][j] = v[c++];
            }
        }
        return mat;
    }
};