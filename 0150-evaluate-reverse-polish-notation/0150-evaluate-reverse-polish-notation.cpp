class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack <long> stk;
        for(auto t:tokens){
            if(t.size()>1 || isdigit(t[0]))
                stk.push(stoi(t));
            else {
                long b = stk.top(); stk.pop();
                long a = stk.top(); stk.pop();
                switch(t[0]){
                    case '+':   stk.push(a+b);  break;
                    case '-':   stk.push(a-b);  break;
                    case '*':   stk.push(a*b);  break;
                    case '/':   stk.push(a/b);  break;
                }
            }
        }
        return (int)stk.top();
    }
};