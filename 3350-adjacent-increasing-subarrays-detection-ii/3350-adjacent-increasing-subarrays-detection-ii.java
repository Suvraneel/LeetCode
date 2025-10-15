class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), prev = 0, curr = 1, ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) // incr curr streak
                curr++;
            else { // reset streak after recording stats
                ans = Math.max(ans, Math.min(prev, curr)); // <-|-> Take only valid prev & curr window
                ans = Math.max(ans, prev / 2); // also consider that prev window could be split into 2 adj ones
                prev = curr;
                curr = 1;
            }
        }
        ans = Math.max(ans, Math.min(prev, curr)); // account for last running streaks (curr & prev)
        ans = Math.max(ans, Math.max(prev, curr) / 2); // account for split of last running streaks
        return ans;
    }
}