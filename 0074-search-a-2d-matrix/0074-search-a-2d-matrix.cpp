class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        // if(!m || !n)    return false;
        int lo=0, hi=m*n-1, mid, i, j;
        while(lo<=hi){
            mid = (lo+hi)/2;
            i=mid/n, j=mid%n;
            if(target==matrix[i][j])
                return true;
            else if(target<matrix[i][j])
                hi = mid-1;
            else lo = mid+1;
        }
        return false;
    }
};