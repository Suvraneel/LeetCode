class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 1, ans = 1;
        if (n <= 1)
            return n;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            if (nums[i] == nums[i - 1] + 1)
                count++;
            else
                count = 1;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}