class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> m;
        vector<vector<string>> v;
        int i=0;
        for(auto s:strs){
            string K = s;
            sort(K.begin(),K.end());
            if(!m[K])
                m[K]=++i, v.push_back(vector<string>(1,s));
            else v[m[K]-1].push_back(s);
        }
        return v;
    }
};