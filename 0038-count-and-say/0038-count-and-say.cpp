class Solution {
public:
    string countAndSay(int n) {
        if(n==1)
            return "1";
        string s = countAndSay(n-1), res="";
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
};