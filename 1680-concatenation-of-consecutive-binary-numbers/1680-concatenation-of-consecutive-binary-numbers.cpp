class Solution {
public:
    int concatenatedBinary(int n) {
        long res=0;
        for(int i=1; i<=n; i++){
            res = (res << 32-__builtin_clz(i))%1000000007 + i;
        }
        return (int)res;
    }
};