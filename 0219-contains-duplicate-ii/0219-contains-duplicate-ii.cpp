class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> m;
        for(uint_fast8_t i=0; i<(uint_fast8_t)nums.size(); i++){
            if(m[nums[i]] && i-m[nums[i]]<k)
                return true;
            m[nums[i]]=i+1;
        }
        return false;
    }
};