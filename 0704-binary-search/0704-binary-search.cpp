class Solution {
public:
    int search(vector<int>& nums, int target) {
        int lt=0, rt=nums.size()-1, mid;
        while(lt<rt){
            mid=lt+(rt-lt)/2;
            nums[mid]<target?lt=mid+1:rt=mid;
        }
        return nums[lt]==target?lt:-1;
    }
};