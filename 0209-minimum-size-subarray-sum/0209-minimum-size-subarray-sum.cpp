class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int ans=INT_MAX, runningSum=0, start=0, end=0;
        bool valid = false;
        for(; end<nums.size();){
            runningSum+=nums[end++];
            while(runningSum>=target){
                valid = true;
                ans = min(ans, end-start);
                runningSum-=nums[start++];
            }
        }
        return valid?ans:0;
    }
};