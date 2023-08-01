class Solution {
public:
    vector<vector<int>> res;
    void solve(int start, int n, int k, vector<int> v = {}){
        if(v.size()==k)
            res.push_back(v);
        else if(v.size()+n-start+1<k);
        else
            for(int i=start; i<=n; i++){
                v.push_back(i);
                solve(i+1, n, k, v);
                v.pop_back();
            }
    }

    vector<vector<int>> combine(int n, int k) {
        solve(1, n, k);
        return res;
    }
};