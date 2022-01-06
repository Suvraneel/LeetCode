class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        int size = 0;
        map <int, int> m;
        for(auto e : trips){
            m[e[1]]+=e[0];
            m[e[2]]-=e[0];
        }
        for(auto it=m.begin(); it!=m.end(); it++){
            size+=it->second;
            if (size>capacity)
                return false;
        }
        return true;
    }
};