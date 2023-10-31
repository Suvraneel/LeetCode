class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        vector<int> v(pref.size(), 0);
        int token = 0;
        for(int i=0; i<pref.size(); i++){
            v[i] = token^pref[i];
            token=pref[i];
        }
        return v;
    }
};