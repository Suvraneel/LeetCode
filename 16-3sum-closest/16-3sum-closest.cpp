class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int diff=INT_MAX, res=0;
        sort(nums.begin(), nums.end());
        for(int i=0; i<nums.size()-2; i++){
            int j=i+1, k=nums.size()-1;
            int newTarget = target-nums[i];
            while(j<k){
                int newDiff = newTarget - nums[j] - nums[k];
                if(abs(newDiff)<diff){
                    res=target-newDiff;
                    if(diff==abs(newDiff))
                        return res;
                    diff=abs(newDiff);
                }
                newDiff<0?k--:j++;
            }
        }
        return res;
    }
};