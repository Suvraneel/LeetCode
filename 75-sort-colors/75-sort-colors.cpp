class Solution {
public:
    void sortColors(vector<int>& nums) {
        int lt=0, rt=nums.size()-1, mid=lt;
        while(mid<=rt){
            switch(nums[mid]){
                case 0: 
                    swap(nums[lt++],nums[mid++]);
                    break;
                case 1: 
                    mid++;
                    break;
                case 2:
                    swap(nums[mid],nums[rt--]);
                    break;
            }
        }
    }
};