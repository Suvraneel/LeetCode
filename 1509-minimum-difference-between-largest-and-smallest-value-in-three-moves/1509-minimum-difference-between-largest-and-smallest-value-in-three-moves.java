class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 4)
            return 0;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++)
            diff = Math.min(nums[n - 4 + i] - nums[i], diff);
        return diff;
    }
}