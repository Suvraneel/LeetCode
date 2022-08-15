class Solution {
public:
    int romanToInt(string s) {
        map <char, int> m;
        m['I'] = 1;
        m['V'] = 5;
        m['X'] = 10;
        m['L'] = 50;
        m['C'] = 100;
        m['D'] = 500;
        m['M'] = 1000;
        int res=0,temp=0;
        for (int i=0; i<s.length(); i++){
            if (m[s[i]]>temp){
                temp = m[s[i]] - temp;
                continue;
            }
            res += temp;
            temp = m[s[i]];
        }
        res += temp;
        return res;
    }
};