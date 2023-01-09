class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums, long long res = 0, int ct = 0) {
        for(auto e:nums)
            e ? ct=0: ct++, res+=ct;
        return res;
    }
};