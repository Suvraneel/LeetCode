class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> m;
        // store all vals in priority queue (no need to sort since PQ does that)
        // note that all diagonal elements have equal value of `i-j`, we use that as a defining criteria for classification when stored.
        for(int i=0; i<mat.size(); i++){
            for (int j=0; j<mat[0].size(); j++){
                m[i-j].push(mat[i][j]);
            }
        }
        // Replace the values back into original matrix in sorted order 
        for(int i=0; i<mat.size(); i++){
            for (int j=0; j<mat[0].size(); j++){
                mat[i][j] = m[i-j].top();   // top elem of PQ (ie, min-heap)
                m[i-j].pop();   // pop top elem... cuz its got its correct place in matrix
            }
        }
        return mat;
    }
};