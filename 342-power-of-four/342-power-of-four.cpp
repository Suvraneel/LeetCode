class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n<=0) return false;
        float a = log10(n)/log10(4);
        return floor(a)==a;
    }
};