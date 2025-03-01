class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        int ctZero=0;
        for(int i=0; i<nums.size()-1; i++)
            if(nums[i]==nums[i+1])
                nums[i]*=2, nums[i+1]=0;
        // for(int lt=0,rt=1; max(lt,rt)<nums.size();){
        //     if (nums[lt])   // find 0s
        //         lt++;
        //     while(rt<=lt)
        //         rt++;
        //     if (!nums[rt])  // find non-zeros
        //         rt++;
        //     else swap(nums[lt], nums[rt]);
        // }
        for(int lt=0,rt=0; rt<nums.size();rt++){
            if(nums[rt])
                nums[lt++]=nums[rt];
            else ctZero++;
        }
        int rt=nums.size()-1;
        while(ctZero--)
            nums[rt--]=0;
        return nums;
    }
};