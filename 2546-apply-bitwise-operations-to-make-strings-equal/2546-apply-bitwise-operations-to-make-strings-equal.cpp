class Solution {
public:
    bool makeStringsEqual(string s, string target) {
        int s0=0, s1=0, t0=0, t1=0;
        for(auto c: s)
            c=='0'?s0++:s1++;
        for(auto c: target)
            c=='0'?t0++:t1++;
        // 0   1  ---> 1   1
        // 0   0  ---> 0   0  (useless)
        // 1   1  ---> 1   0
        if(t1==s1) return true; // posn doesnt matter since, using combination 1st and 3rd successively posns can be swapped
        return s1&&t1;  // atleast one 1 guarantees change of all the other required bits (Note that one 1 still remains unchanged finally)
    }
};