// class Solution {
// public:
//     bool closeStrings(string word1, string word2) {
//         if(word1.size()!=word2.size())
//             return false;
//         unordered_set <char> s1, s2;
//         unordered_map <char, int> m1, m2;
//         vector <int> v1, v2;
//         for(char c: word1)
//             s1.insert(c), m1[c]++;
//         for(char c: word2)
//             s2.insert(c), m2[c]++;
//         if(s1!=s2)
//             return false;
//         for(auto [K, V]: m1)
//             v1.push_back(V);
//         for(auto [K, V]: m2)
//             v2.push_back(V);
//         sort(v1.begin(), v1.end());
//         sort(v2.begin(), v2.end());
//         return v1==v2;
//     }
// };

class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size()!=word2.size())
            return false;
        vector <int> v1(26, 0), v2(26, 0);
        for(int i=0; i<word1.size(); i++)
            v1[word1[i]-'a']++, v2[word2[i]-'a']++;
        for(int i=0; i<26; i++)
            if((bool)v1[i] ^ (bool)v2[i])
                return false;
        sort(v1.begin(), v1.end());
        sort(v2.begin(), v2.end());
        return v1==v2;
    }
};