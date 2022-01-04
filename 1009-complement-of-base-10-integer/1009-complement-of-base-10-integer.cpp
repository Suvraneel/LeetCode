class Solution {
public:
    int bitwiseComplement(int n) {
        if (!(n)) return 1;
        int t = 32-__builtin_clz(n);
        int num = 0;
        for(int i=0;i<t;i++){
            num += pow(2,i);
        }
        return (num^n);
    }
};