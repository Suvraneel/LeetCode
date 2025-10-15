class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), prev = 0, curr = 1, ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                curr++;
            else {
                ans = Math.max(ans, Math.min(prev, curr));
                ans = Math.max(ans, prev / 2);
                prev = curr;
                curr = 1;
            }
        }
        ans = Math.max(ans, Math.min(prev, curr));
        ans = Math.max(ans, Math.max(prev, curr) / 2);
        return ans;
    }
}