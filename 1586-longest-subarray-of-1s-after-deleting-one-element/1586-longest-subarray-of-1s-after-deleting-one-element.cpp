class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int maxStreak = 0, currStreak = 0, lastStreak=0;
        for(int i=0; i<nums.size(); i++){   // Modded Sliding Window
            if(!nums[i]){
                maxStreak = max(maxStreak, currStreak+lastStreak);
                lastStreak = currStreak;
                currStreak = 0;
            }
            else currStreak++;
        }
        int ans = max(maxStreak, currStreak+lastStreak); //Last streak might not be flanked by 0 at the end.
        return ans==nums.size()?ans-1:ans;  //Atleast 1 element to be removed
    }
};