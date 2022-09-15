class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        sort(changed.begin(), changed.end());
        map<int, int> m;
        vector<int> v;
        for(auto e:changed){
            if(e%2 || !m[e/2])
                m[e]++;
            else {
                m[e/2]--;
                v.push_back(e/2);
            }
        }
        for (auto g:m)
            if(g.second){
                v.clear();
                break;
            }
        return v;
    }
};