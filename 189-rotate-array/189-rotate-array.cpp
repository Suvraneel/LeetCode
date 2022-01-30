class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector <int> v;
        k %= nums.size();
        for (int i=nums.size()-k; i<nums.size();i++)
            v.push_back(nums[i]);
        for (int i=nums.size()-1; i>k-1;i--)
            nums[i] = nums[i-k];
        for (int i=0; i<k;i++)
            nums[i] = v[i];
        
    }
};