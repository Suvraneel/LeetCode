class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector <int> v(n+1, 0); // person => {trusted_by_ct, trusts_someone}
        for(auto e: trust)
            v[e[1]]++, v[e[0]]=INT_MIN;
        for(int i=1; i<v.size(); i++)
            if(v[i]==n-1)
                return i;
        return -1;
    }
};