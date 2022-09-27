class Solution {
public:
    string minWindow(string s, string t) {
        map<char, int> m;
        int minSum=INT_MAX;
        for(char c: t)
            m[c]++;
        int lt=0, rt=0, ct=0;
        string res = s;
        for(;rt<s.size();rt++){
            if(m[s[rt]]>0)
                ct++;
            m[s[rt]]--;
            if(ct==t.length()){
                while(m[s[lt]]<0 && lt<rt)   // rm elems from slidin win bcz -ve => we've more than reqd
                    m[s[lt]]++, lt++;
                if(res.length()>rt-lt+1)
                    res=s.substr(lt,rt-lt+1);
                // cout << res << "$" <<endl;
            }
            // cout << s.substr(lt, rt-lt+1) << "\t";
        }
        for(auto k:m)
            if(k.second>0)
                return "";
        return res;
    }
};