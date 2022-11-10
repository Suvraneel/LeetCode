// class Solution {
// public:
//     string removeDuplicates(string s) {
//         for(int i=1; i<s.size(); i++)
//             if(s[i]==s[i-1])
//                 s = s.substr(0,i-1)+s.substr(i+1), i=1?0:i-2;
//         return s;
//     }
// };

class Solution {
public:
    string removeDuplicates(string s) {
        stack <char> stk;
        for(int i=0; i<s.size(); i++)
            if(!stk.empty() && s[i]==stk.top())
                stk.pop();
            else stk.push(s[i]);
        s="";
        while(!stk.empty())
            s=stk.top()+s, stk.pop();
        return s;
    }
};