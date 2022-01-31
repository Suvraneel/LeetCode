class Solution {
public:
    int maximumWealth(vector<vector<int>>& a) {
        int m = a.size(), n = a[0].size(), res=-1;
        for (int i=0; i<m; i++){
            int w=0;
            for(int j=0; j<n; j++)
                w+=a[i][j];
            res=max(res, w);
        }
        return res;
    }
};