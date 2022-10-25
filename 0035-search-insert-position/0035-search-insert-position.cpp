class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        // Range of Answer : [0, n]
        int lt=0, rt=nums.size()-1, mid;
        while(lt<=rt){
            mid = lt+(rt-lt)/2;
            nums[mid]<target?lt=mid+1:rt=mid-1;
        }
        return lt;
    }
};