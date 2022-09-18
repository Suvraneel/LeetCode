class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        int odd=0, even=1;
        while(1){
            while(!(nums[odd]%2)){
                odd+=2;
                if(odd>=nums.size())
                    return nums;
            }
            while(nums[even]%2){
                even+=2;
                if(even>=nums.size())
                    return nums;
            }
            swap(nums[odd], nums[even]);
        }
        return nums;
    }
};