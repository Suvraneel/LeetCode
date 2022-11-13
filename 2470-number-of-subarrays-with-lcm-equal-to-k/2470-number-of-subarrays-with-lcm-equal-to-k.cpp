class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int curr_lcm = nums[i];
            for (int j = i; j < nums.size(); j++) {
                curr_lcm = lcm(curr_lcm, nums[j]);
                // cout << nums[i] << nums[j] << res <<curr_lcm<< endl;
                if(curr_lcm == k)
                    res++;
                else if(curr_lcm>k)
                    break;
            }
        }
        return res;
    }
};