class Solution {
public:
    int maximumWealth(vector<vector<int>>& a) {
        int res=-1;
        for (int i=0; i<a.size(); i++){
            int w=0;
            for(int j=0; j<a[0].size(); j++)
                w+=a[i][j];
            res=max(res, w);
        }
        return res;
    }
};