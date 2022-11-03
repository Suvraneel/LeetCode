class Solution {
public:
    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        unordered_map <string, vector<string>> m; // [K, V] : creator => {"popularity_yet", "id", "max_views"}
        vector<vector<string>> res;
        long long int max_popu=0;
        for(int i=0; i<creators.size(); i++){
            if(m[creators[i]].empty())
                m[creators[i]] = {"0", ids[i], "0"};
            long long int popu = stol(m[creators[i]][0])+views[i];
            if (stol(m[creators[i]][2]) == views[i])
                m[creators[i]][1] = min(m[creators[i]][1],ids[i]); // lex small id
            else if (stol(m[creators[i]][2]) < views[i])
                 m[creators[i]][2] = to_string(views[i]), m[creators[i]][1] = ids[i];   // update max viewed id
            m[creators[i]][0] = to_string(popu);
            max_popu = max(max_popu, popu);
        }
        for(auto [K, V]: m)
            if(stol(V[0])==max_popu)
                res.push_back({K, V[1]});
        return res;
    }
};