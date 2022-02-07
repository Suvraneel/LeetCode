class Solution {
public:
    char findTheDifference(string s, string t) {
        map <char, int> ms, mt;
        for (int i=0; i < s.length(); i++)
            ms[s[i]]++;
        for (int i=0; i < t.length(); i++)
            mt[t[i]]++;
        for (auto i:mt)
            if(ms[i.first]<i.second)
                return i.first;
        return 'a';             // fallback
    }
};