class Solution {
public:
    int findMaxLength(vector<int>& a) {
        int f=0, ans=0;
        unordered_map<int,int>mp;
        mp[0] = -1;
        for(int i=0; i<a.size(); i++){
            f += a[i]==1 ? 1 : -1;
            if(mp.find(f) == mp.end())
              mp[ f ] = i;
            else
              ans = max(ans, i - mp[f] );
        }
        return ans;
    }
};