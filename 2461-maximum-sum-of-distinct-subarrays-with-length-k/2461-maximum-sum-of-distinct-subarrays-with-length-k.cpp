class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        long long int res = 0, currSum=0;
        unordered_set<int> s;
        for(int lt=0, rt=0; lt<=nums.size()-k; rt++){
            if (s.find(nums[rt])!=s.end())  // found
                lt=rt, rt--, s.clear(), currSum=0;
            else s.insert(nums[rt]), currSum+=nums[rt];
            if(s.size()==k)
                res=max(res, currSum), currSum-=nums[lt], s.erase(nums[lt]), lt++;
        }
        return res;
    }
};