class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int running_sum = 0;
        for(int i=0; i<nums.size(); i++)
            nums[i] = running_sum += nums[i];
        unordered_map<int, int> seen;
        // Based on the result that if SUM_JmodK==SUM_ImodK  => (SUM_J-SUM_I)modK==0
        for(int i=0; i<nums.size(); i++){
            int rem = nums[i]%k;
            if(i && !rem)      // base case: contiguous subarray of all array elems upto index i
                return true;
            if(seen[rem]){
                if(i+1-seen[rem]>=2)  // result found
                    return true;
                // else dont update array, cuz it doesnt hurt to find the largest satisfying array
            }
            else seen[rem] = i+1;     // first occurance -> store
        }
        return false;   // not possible
    }
};