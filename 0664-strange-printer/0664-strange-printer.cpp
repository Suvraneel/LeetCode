class Solution {
public:
    int strangePrinter(string s) {
        s.erase(unique(s.begin(), s.end()), s.end());
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n));
        // if substr.size()==1, then prints reqd: 1;
        for(int i=0; i<n; ++i)
            dp[i][i] = 1;

        for(int i=1; i<n; ++i){
            for(int j=0; j<n-i; ++j){
                int k = i + j;
                if(s[j]==s[k]){
                    dp[j][k] = dp[j][k-1];
                } else {
                    dp[j][k] = numeric_limits<int>::max();
                    for (int l = j; l < k; ++l) {
                        dp[j][k] = min(dp[j][k], dp[j][l] + dp[l + 1][k]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
};