class Solution {
public:
    int minimumAverageDifference(vector<int>& n) {
        vector <long> nums = {n[0]};
        for(int i=1; i<n.size(); i++)
            nums.push_back(n[i]+nums.back());
        int diff = INT_MAX, sum=nums.back(), len=nums.size(), res=0;
        for(int i=0; i<len; i++){
            int avgLt = round(nums[i]/(i+1));
            int avgRt = round((nums.back()-nums[i])/max(len-i-1, 1));
            int cur = abs(avgLt-avgRt);
            if(diff>cur)
                diff = cur, res = i;
            // cout << avgLt << "\t" << avgRt << endl;
        }
        return res;
    }
};