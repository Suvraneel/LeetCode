class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int lt=0, rt=1;
        while(rt<nums.size()){
            while(rt<nums.size() && nums[rt]==nums[rt-1])
                rt++;
            if(rt<nums.size()){
                nums[++lt] = nums[rt];
                rt++;
            }
        }
        return lt+1;
    }
};