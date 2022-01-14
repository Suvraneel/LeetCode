class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        bool negative = false;
        while(s[i]==' '){
            i++;
            cout << s[i];
            continue;
        }
        if (s[i]=='-'){
            negative = true;
            i++;
        }
        else if (s[i]=='+')
            i++;
        int res = 0;
        for (; i<s.length(); i++){
            if(!(isdigit(s[i])))
                break;
            long temp = (long)res*10 + (s[i]-'0');
            if (temp>=INT_MAX){
                return ((negative) ? ((temp==INT_MAX) ? INT_MIN+1:INT_MIN):INT_MAX);
            }
            else res = (int)temp;
        }
        return (negative ? -(res):res);
    }
};