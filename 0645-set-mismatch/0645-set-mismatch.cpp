class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        unordered_set <int> s;
        int xor1=0, xor2=0, i=1, xor3=0;
        for(auto e: nums)
            s.insert(e), xor1^=e, xor3^=i++;
        for(auto e: s)
            xor2^=e;
        return {xor1 ^ xor2, xor2 ^ xor3};
    }
};