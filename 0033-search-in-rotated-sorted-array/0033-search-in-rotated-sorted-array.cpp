class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()==1)
            return nums[0]==target?0:-1;
        int lt=0, rt=nums.size()-1, mid;
        while(lt<=rt){
            mid = lt+(rt-lt)/2;
            // cout << lt << mid << rt << endl;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>nums[lt]){  // lt -> mid sorted
                if(nums[lt]==target)
                    return lt;
                if(target>nums[lt] && target<nums[mid])     // do normal binary search
                    rt = mid-1;
                else lt = mid+1;    // skewed binary search again
            } else {    // mid is beyond pivot from lt
                if(nums[rt]==target)
                    return rt;
                if(target<nums[rt] && target>nums[mid])     // do normal binary search
                    lt = mid+1;
                else rt = mid-1;    // skewed binary search again
            }
        }
        return -1;
    }
};