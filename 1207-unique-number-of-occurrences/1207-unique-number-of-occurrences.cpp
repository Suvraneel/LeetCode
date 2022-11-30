class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map <int, int> m1, m2;
        unordered_set <int> s;
        for(auto e: arr)
            m1[e]++;
        for(auto [K, V]: m1)
            if(!m2[V])
                m2[V]=K;
            else return false;
        return true;
    }
};


// class Solution {
// public:
//     bool uniqueOccurrences(vector<int>& arr) {
//         unordered_map <int, int> m;
//         unordered_set <int> s;
//         for(auto e: arr)
//             m[e]++;
//         for(auto e: m)
//             s.insert(e.second);
//         return m.size()==s.size();
//     }
// };