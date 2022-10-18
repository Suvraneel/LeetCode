class Solution {
public:
    string countAndSay(int n) {
        string ans="1";
        for(int i=2; i<=n; i++){
            string res="";
            char prev=ans[0];
            int ct=0;
            for(char c: ans){
                if(c==prev)
                    ct++;
                else {
                    res+=to_string(ct)+to_string(prev-'0');
                    ct=1;
                    prev=c;
                }
            }
            res+=to_string(ct)+to_string(prev-'0');
            ans=res;
        }
        return ans;
    }
};