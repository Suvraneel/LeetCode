class Solution {
public:
    bool checkIfPangram(string sentence) {
        vector<bool> v(26,false);
        for(char c: sentence)
            v[c-'a']=true;
        for(auto b: v)
            if(!b)
                return false;
        return true;
    }
};