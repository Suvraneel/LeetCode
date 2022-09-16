class Solution {
public:
    vector<vector<int>> dp;
    int solve(vector<int>& nums, vector<int>& multipliers, int start, int i) {
        if(i>= multipliers.size())
            return 0;
        if(dp[start][i]==INT_MIN){
            // Since, nums.size() - end + start - 1 = i    => Therefore, we can say :
            int end = nums.size() - 1 - i + start;
            dp[start][i] = max(solve(nums, multipliers, start, i+1) + nums[end]*multipliers[i], solve(nums, multipliers, start+1, i+1) + nums[start]*multipliers[i]);
        }
        return dp[start][i];
    }
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        dp.resize(multipliers.size()+1,vector<int>(multipliers.size()+1,INT_MIN));
        return solve(nums, multipliers, 0, 0);
    }
};