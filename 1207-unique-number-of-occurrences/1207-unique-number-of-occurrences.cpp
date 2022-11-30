class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map <int, int> m1,m2;
        for(auto e: arr)
            m1[e]++;
        for(auto [K, V]: m1)
            if(m2[V]==0)
                m2[V]=K;
            else return false;
        return true;
    }
};