class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> ans;
        int eSum = 0;
        for(auto n:nums)
            if(!(n%2))
                eSum+=n;
        cout<<eSum;
        for(auto q: queries){
            eSum -= nums[q[1]]%2?0:nums[q[1]];
            nums[q[1]]+=q[0];
            eSum += nums[q[1]]%2?0:nums[q[1]];
            ans.push_back(eSum);
        }
        return ans;
    }
};