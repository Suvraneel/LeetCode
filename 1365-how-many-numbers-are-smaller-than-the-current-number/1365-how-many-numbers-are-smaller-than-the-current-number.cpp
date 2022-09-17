class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        map<int,int> m;
        for(auto e:nums)
            m[e]++;
        int prev=0;
        for (auto e:m){
            int ct = e.second;
            m[e.first]=prev;
            prev+=ct;
        }
        for(int i=0; i<nums.size(); i++)
            nums[i] = m[nums[i]];
        return nums;
    }
};