#include <bits/stdc++.h>
using namespace std;

string decodeString(string s) {
    stack <string> stk;
    string sub, word, num;
    for (int i=0; i<s.length(); i++){
        // cout << s[i];
        if (s[i] == ']'){
            sub = "";
            word = "";
            while(stk.top() != "["){
                sub = stk.top() + sub;
                stk.pop();
                cout << "$ " << sub << endl;
            };
            stk.pop();
            num = "";
            while (stk.top() <= "9" && stk.top()>="0"){
                num = stk.top() + num;
                cout << "$ " << num << endl;
                stk.pop();
                if (stk.empty()) break;
            }
            cout << endl <<num;
            int rep = stoi(num);
            while (rep--)
                word += sub;
            stk.push(word);
            cout << "# " << word << endl;
            continue;
        }
        stk.push(string(1,s[i]));
    }
    string res = "";
    while (!(stk.empty())){
        res = stk.top() + res;
        stk.pop();    
    }
    return res;
}

int main(){
    string s;
    // cin >> s;
    // s = "3[a2[c]]";
    // s = "2[abc]3[cd]ef";
    // s = "abc3[cd]xyz";
    s = "100[leetcode]";
    cout << decodeString(s) << "\n";
    return 0;
}  
  
