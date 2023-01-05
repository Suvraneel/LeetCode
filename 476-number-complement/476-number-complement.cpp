class Solution {
public:
    int findComplement(int num) {
        int lead = __builtin_clz(num);
        int s = pow(2, 32-lead)-1;
        return (num^s);
    }
};