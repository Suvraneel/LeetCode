class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map <int, int>  m;
        vector<int> v = {0, 0};
        for (int i=0; i<nums.size(); i++){
            if(m[target-nums[i]]){
                v[0]=m[target-nums[i]]-1;   // since we stored as index+1
                v[1]=i;
                return v;
            }
            else m[nums[i]]=i+1;    //+1 bcz if we push index 0 to map, then it will be detected as null... So converting to 1-indexed array;
        }
        return v;
    }
};