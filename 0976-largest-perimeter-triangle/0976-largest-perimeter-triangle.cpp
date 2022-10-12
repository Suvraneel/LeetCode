class Solution {
public:
    int largestPerimeter(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int i=nums.size()-1;
        while(i>=2 && nums[i-2]+nums[i-1]<=nums[i])
            i--;
        return i>=2?nums[i-2]+nums[i-1]+nums[i]:0;
    }
};