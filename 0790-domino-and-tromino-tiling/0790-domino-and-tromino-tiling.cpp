class Solution {
public:
    int numTilings(int n) {
        int mod=1e9+7;
        long long dp1 = 1, dp2 = 2, dp3 = 5, dp4;
        if(n<=3){
            switch(n){
                case 1: return dp1;
                case 2: return dp2;
                case 3: return dp3; 
            }
        }
        for (int i=4; i<=n; i++) {
            dp4 = (2* dp3 + dp1) % mod;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
        }
        return dp4;
    }
};