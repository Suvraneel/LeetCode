class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int lt=1, rt=1;
        for(;rt<nums.size(); rt++){
            if(nums[rt]!=nums[rt-1])
                nums[lt++]=nums[rt];
        }
        return lt;
    }
};