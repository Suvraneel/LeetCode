class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length()!=t.length())
            return false;
        map <char, int> m;
        for(int i=0; i<s.length(); i++)
            m[s[i]]++;
        for(int i=0; i<t.length(); i++)
            m[t[i]]--;
        for(auto e:m)
            if(e.second!=0)
                return false;
        return true;
    }
};