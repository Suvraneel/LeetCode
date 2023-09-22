class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i=0, j=0;
        for(; i<s.size(); ){
            for(; j<t.size(); j++){
                if(s[i]==t[j]) i++;
            }
            if(j==t.size() && i!=s.size())
                return false;
        }
        return true;
    }
};