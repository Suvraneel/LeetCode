class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n<=0) return false;
        return floor(log10(n)/log10(4))==(log10(n)/log10(4));
    }
};