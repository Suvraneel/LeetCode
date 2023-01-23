class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector <pair<int, bool>> v(n+1, {0, false}); // person => {trusted_by_ct, trusts_someone}
        for(auto e: trust)
            v[e[1]].first++, v[e[0]].second=true;
        for(int i=1; i<v.size(); i++)
            if(v[i].first==n-1 && !v[i].second)
                return i;
        return -1;
    }
};