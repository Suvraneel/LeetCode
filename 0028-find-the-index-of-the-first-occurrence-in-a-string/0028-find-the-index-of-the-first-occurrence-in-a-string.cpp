class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length()>haystack.length())
            return -1;
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            if(needle==haystack.substr(i, needle.length()))
                return i;
        }
        return -1;
    }
};