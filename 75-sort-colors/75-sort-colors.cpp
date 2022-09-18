class Solution {
public:
    void sortColors(vector<int>& nums) {
        int lt=0, rt=nums.size()-1, mid=lt;
        while(mid<=rt){
            if(nums[mid]==0)
                swap(nums[lt++],nums[mid++]);
            else if(nums[mid]==2)
                swap(nums[mid],nums[rt--]);
            else mid++;
        }
    }
};