class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, lt = 0;
        long curr = 0;
        for (int rt = 0; rt < n; rt++) {
            int target = nums[rt];
            curr += target;
            if ((rt - lt + 1l) * target - curr > k) {
                curr -= nums[lt];
                lt++;
            }
        }
        return n - lt;
    }
}