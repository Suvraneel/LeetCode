class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] < k)
            return -1;
        int n = nums.length, maxm = nums[n - 1], ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (maxm == nums[i])
                continue;
            maxm = nums[i];
            ops++;
        }
        if (nums[0] > k)
            ops++;
        return ops;
    }
}