class Solution {
public:
    bool isAnagram(string s, string t) {
        map <char, int> m, n;
        for(int i=0; i<s.length(); i++)
            m[s[i]]++;
        for(int i=0; i<t.length(); i++)
            n[t[i]]++;
        if (m.size()!=n.size())
            return false;
        return m==n;
    }
};