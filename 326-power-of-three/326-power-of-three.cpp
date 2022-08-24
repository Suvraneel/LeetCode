class Solution {
public:
    bool isPowerOfThree(int n) {
        if (n<1) return false; 
        double val = log10(n)/log10(3);
        return floor(val)==val;
    }
};