class Solution {
public:
    int reverse(int x) {
        long ans = 0;
        while(x){
            int D = x%10;
            ans = ans*10 + D;
            if(ans>INT_MAX || ans<INT_MIN)
                return 0;
            x /= 10;
        }
        return (int)ans;
    }
};