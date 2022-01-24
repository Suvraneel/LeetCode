class Solution {
public:
    bool detectCapitalUse(string word) {
        int c=0;
        for (int i=0; i<word.length(); i++){
            if(word[i]>='A' && word[i]<='Z')
                c++;
        }
        if(c==word.length()||c==0)
            return true;
        else if(c==1 && word[0]>='A' && word[0]<='Z')
            return true;
        return false;
    }
};