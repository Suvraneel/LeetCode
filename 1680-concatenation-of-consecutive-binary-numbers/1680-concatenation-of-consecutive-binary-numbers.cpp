class Solution {
public:
    int concatenatedBinary(int n) {
        long res=0;
        for(int i=1; i<=n; i++){
            res = (res << (int)(log2(i)+1))%1000000007 + i;
        }
        return (int)res;
    }
};