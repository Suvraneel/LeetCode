class Solution {
public:
    char findTheDifference(string s, string t) {
        map <char, int> ms, mt;
        for (int i=0; i < s.length(); i++)
            ms[s[i]]++, mt[t[i]]++;
        mt[t[t.length()-1]]++;
        for (auto i:mt)
            if(ms[i.first]<i.second)
                return i.first;
        return 'a';             // fallback
    }
};