class Solution {
public:
// https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
    int maxCoins(vector<int>& nums) {
        int orig_size = nums.size();
		// virtual bounds for simplicity
        nums.insert(nums.begin(), 1);
        nums.insert(nums.end(), 1);
        vector<vector<int>> dp(nums.size(), vector<int>(nums.size(), 0));
        int len = 1;
		// compute all possible sizes as subarray of size len needs to know results for len-1, len-2 and etc.
        while(len <= orig_size){
		    // start is i
            int i = 1;
			// end included
            int end = i + len - 1;
			// this window has size len, then slide it to the left by for as long as you can.
            for(; end < (nums.size() - 1); i++, end++){
			    // in each range, try every element as last baloon to burst, compute what it brings 
				// and you computed results for left and right parts
                for(int last = i; last <= end; last++){
                    int left_range_res = dp[i][last - 1];
                    int right_range_res = dp[last + 1][end];
                    int coins_in_last = nums[last];
					// nums[i - 1] is the first baloon to the left that isn't burst so it is your left boundary(it might be virtual)
					// nums[end + 1] is the first baloon to the right that isn't burst so it is your right boundary(it might be virtual)
                    int last_burst_score = nums[i - 1] * coins_in_last * nums[end + 1];
                    dp[i][end] = max(dp[i][end], left_range_res + last_burst_score + right_range_res);
                }
            }
			// now find results for len+1 using what we have computed.
            len++;
        }
		// this is because we have added two virtual bounds.
        return dp[1][orig_size];
    }
};