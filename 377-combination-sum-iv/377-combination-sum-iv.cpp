class Solution {
public:
    vector<int> dp;
    
    Solution() {
        dp.resize(1001);
        fill(dp.begin(), dp.end(), -1);
    }
    int combinationSum4(vector<int>& nums, int target, int sum=0) {
        if(sum>target) return 0; // overshoot
        else if (sum==target) return 1; // counter++
        else if (dp[sum]!=-1) return dp[sum]; // if memoised already
        int res=0;
        for (auto n: nums){
            if(sum+n<=target)
                res+=combinationSum4(nums, target, sum+n);
        }
        return dp[sum] = res;
    }
};