class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] instability = new int[n];
        for (int i = 0; i < n; i++) {
            instability[i] += max = Math.max(max, nums[i]);
            instability[n - 1 - i] -= min = Math.min(min, nums[n - 1 - i]);
        }
        // System.out.println(Arrays.toString(prefMax));
        // System.out.println(Arrays.toString(suffMin));
        for (int i = 0; i < n; i++)
            if (instability[i] <= k)
                return i;
        return -1;
    }
}