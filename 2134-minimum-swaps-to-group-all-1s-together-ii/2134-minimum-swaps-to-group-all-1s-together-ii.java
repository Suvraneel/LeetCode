class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, totalOnes = 0;
        if (n == 1)
            return 0;
        for (int i = 0; i < n; i++)
            totalOnes += nums[i];
        int onesCt = nums[0], minSwaps = Integer.MAX_VALUE;
        for (int st = 0, end = 0; st < n; ++st) {
            if (st != 0)
                onesCt -= nums[st - 1];
            while (end - st + 1 < totalOnes) // expand window
                onesCt += nums[++end % n];
            minSwaps = Math.min(minSwaps, totalOnes - onesCt);
        }
        return minSwaps;
    }
}