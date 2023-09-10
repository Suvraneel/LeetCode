class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        int lt=0, rt=1, sz=nums.size();
        while(1){
            while(lt<sz && nums[lt]%2==lt%2)
                lt+=2;
            while(rt<sz && nums[rt]%2==rt%2)
                rt+=2;
            cout << lt<<"\t"<<rt<<"\n";
            if(lt<sz && rt<sz){
                int temp = nums[lt];
                nums[lt] = nums[rt];
                nums[rt] = temp;
            }
            else break;
        }
        return nums;
    }
};