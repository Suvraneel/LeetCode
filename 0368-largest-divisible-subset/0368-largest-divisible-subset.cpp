class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& v) {
        sort(v.begin(), v.end());
        vector<int> dp(v.size(), 1), pred(v.size(), -1), ans;
        int maxI = 0;
        for(int i=1; i<v.size(); i++){
            for(int j=0; j<i; j++){
                if(!(v[i]%v[j]) && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;    // track largest valid subset ending at idx i
                    pred[i] = j;    // last predecessor to subset ending at idx i
                }
            }
            if(dp[i]>dp[maxI]) maxI = i;   // could be done in a separate for loop
        }
        // reverse engineer ans subset using predecessor chain
        while(maxI>=0){
            ans.push_back(v[maxI]);
            maxI = pred[maxI];
        }
        return ans;
    }
};