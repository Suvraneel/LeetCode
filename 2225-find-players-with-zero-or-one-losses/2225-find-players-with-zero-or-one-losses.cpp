class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        vector<vector<int>> ans(2, vector<int>({}));
        map <int, pair<int, int>> m;
        for (vector<int> v: matches)
            m[v[0]].first++, m[v[1]].second++;
        for (auto [K,P]:m){
            if(P.first+P.second==0)     // no matches played
                continue;
            else if (P.second==1)
                ans[1].push_back(K);
            else if (P.second==0)
                ans[0].push_back(K);
        }
        // sort(begin(ans[0]), end(ans[0]));
        // sort(begin(ans[1]), end(ans[1]));
        return ans;
    }
};