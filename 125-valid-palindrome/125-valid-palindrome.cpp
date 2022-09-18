class Solution {
public:
    bool isPalindrome(string s) {
        int lt=0, rt=s.size()-1;
        while(lt<rt){
            while(lt<rt && !iswalnum(s[lt]))
                lt++;
            while(lt<rt && !iswalnum(s[rt]))
                rt--;
            if(tolower(s[lt++])!=tolower(s[rt--]))
                return false;
        }
        return true;
    }
};