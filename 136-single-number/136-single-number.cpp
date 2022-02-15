class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int xored = 0;
        for(auto e: nums)
            xored ^= e; 
        return xored;
    }
};