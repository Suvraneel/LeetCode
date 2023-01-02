class Solution {
public:
    bool detectCapitalUse(string word) {
        auto isCaps = [](char c)->bool{return (c>='A' && c<='Z');};
        if(!isCaps(word[0])){    // case 2 -> leetcode
            for(auto c:word)
                if (isCaps(c))
                    return false;
        }else{
            if(isCaps(word[1])){    // case 1 -> USA
                for(auto c:word)
                    if (!isCaps(c))
                        return false;
            }
            else for(auto c:word.substr(1))   // case 3 -> Google
                if (isCaps(c))
                    return false;
        }
        return true;
    }
};