class Solution {
public:
    void reverseString(vector<char>& s) {
        int lt=0, rt=s.size()-1;
        while(lt<rt)
            swap(s[lt++],s[rt--]);
    }
};