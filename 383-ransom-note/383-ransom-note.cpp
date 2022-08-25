class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        map <char, int> m;
        for(char c: magazine)
            m[c]++;
        for(char c: ransomNote)
            m[c]--;
        for(auto e: m)
            if(e.second<0)
                return false;
        return true;
    }
};