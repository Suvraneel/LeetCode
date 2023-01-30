class Solution {
public:
    vector<int> dp = {0, 1, 1};
    int tribonacci(int n) {
        if(n<dp.size())   return dp[n];
        dp.push_back(tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1));
        return dp.back();
    }
};