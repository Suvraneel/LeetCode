class Solution {
public:
    string reverseWords(string s) {
        int i=0, x=0;
        while(1){
            x = s.find(' ', i+1);
            if(x==-1){
                reverse(s.begin()+i,s.end());
                break;
            }
            reverse(s.begin()+i,s.begin()+x);
            i=x+1;
        }
        return s;
    }
};