class Solution {
public:
    string convert(string s){
        string res="";
        char prev=s[0];
        int ct=0;
        for(char c: s){
            if(c==prev)
                ct++;
            else {
                res+=to_string(ct)+to_string(prev-'0');
                ct=1;
                prev=c;
            }
        }
        return res+to_string(ct)+to_string(prev-'0');
    }
    string countAndSay(int n) {
        string ans="1";
        for(int i=2; i<=n; i++)
            ans=convert(ans);
        return ans;
    }
};