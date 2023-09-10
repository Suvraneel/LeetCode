class Solution {
public:
    bool isAlpha(char c){
        return ('A'<=c<='Z'||'a'<=c<='z');
    }

    bool isPalindrome(string s) {
        int lt=0, rt=s.size()-1;
        while(lt<rt){
            while(!iswalnum(s[lt]) && lt<rt)
                lt++;
            while(!iswalnum(s[rt]) && lt<rt)
                rt--;
            if(tolower(s[lt])!=tolower(s[rt]))
                return false;
            lt++, rt--;
        }
        return true;
    }
};