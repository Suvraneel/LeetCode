class Solution {
public:
int calculate(string s) {
        int n = s.size();
        stack<int> stk;
        char op='+';long num=0;
        for(int i=0;i<n;i++)
        {
            if(isdigit(s[i])) //s[i]>='0' && s[i]<='9'
                num=num*10 + (s[i]-'0');

            if((!isdigit(s[i])&& !isspace(s[i])) || i==n-1)
            {
                if(op=='+')
                {
                    stk.push(num);
                }
                else if(op=='-')
                {
                    stk.push(-num);
                }
                else if(op=='*')
                {
                    int top=stk.top();stk.pop();
                    num=top*num;
                    stk.push(num);
                }
                else
                {
                    int top=stk.top();
                    stk.pop();
                    num=top/num;
                    stk.push(num);
                }
                op=s[i];num=0;
            }
        }
        int res=0;
        while(!stk.empty()){
            res+=stk.top();
            stk.pop();
        }
        return res;
    }
};