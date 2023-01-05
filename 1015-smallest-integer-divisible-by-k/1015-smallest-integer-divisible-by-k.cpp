class Solution {
public:
    int smallestRepunitDivByK(int k) {
        if (k%2==0 || k%5==0)
            return -1;
        int rem = 0, len = 0;
        for(; len<=k;){
            rem = (rem*10 + 1)%k;
            len++;
            if (!(rem))
                return len;
        }
        return -1;
    }
};