class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map <int, int> m;
        unordered_set <int> s;
        for(auto e: arr)
            m[e]++;
        for(auto e: m)
            s.insert(e.second);
        return m.size()==s.size();
    }
};