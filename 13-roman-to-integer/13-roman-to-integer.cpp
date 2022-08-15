class Solution {
public:
    int romanToInt(string s) {
        map <char, int> m{{'I',1},{'V',5},{'X',10},{'L',50},{'C',100},{'D',500},{'M',1000}};
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