class Solution {
public:
    string makeGood(string s, int sz=0) {
        while (sz != s.size()) {
            sz = s.size();
            for(int i=0; i<s.size(); i++){
                if(('a'<=s[i] && s[i]<='z' && s[i+1]==toupper(s[i])) || ('A'<=s[i] && s[i]<='Z' && s[i+1]==tolower(s[i])))
                    s = s.substr(0,i)+s.substr(i+2);
            }
        }
        return s;
    }
};