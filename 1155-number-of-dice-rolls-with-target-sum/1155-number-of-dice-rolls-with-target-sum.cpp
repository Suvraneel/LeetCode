#define MOD (int)1e9+7
class Solution {
public:
    vector<vector <int>> dp;
    int solve(int n, int k, int target) {
        // cout << n << "," << k << "," << target << endl;
        if(target==0 && n==0)
            return 1;
        if(target<=0 || n<=0)
            return 0;
        if(n==1)
            return target>k ? 0:1;
        if(dp[n][target]!=-1)
            return dp[n][target];
        int res=0;
        for(int i=1; i<=k; i++){
            res+= solve(n-1, k, target-i);
            res%=MOD;
        }
        return dp[n][target] = res;
    }
    
    int numRollsToTarget(int n, int k, int target) {
        dp = vector<vector<int>>(n+1, vector<int>(target+1, -1));
        // for(int i=0; i<n; i++)
        //     for(int j=0; j<target; j++)
        //         if(n==1)
        //             dp[i][j]= target>k ? 0:1;
        return solve(n, k, target);
    }
};