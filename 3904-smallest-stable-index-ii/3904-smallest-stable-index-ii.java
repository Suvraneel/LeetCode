class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        prefMax[0] = nums[0];
        suffMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
            suffMin[n - 1 - i] = Math.min(suffMin[n - i], nums[n - 1 - i]);
        }
        // System.out.println(Arrays.toString(prefMax));
        // System.out.println(Arrays.toString(suffMin));
        for (int i = 0; i < n; i++)
            if (prefMax[i] - suffMin[i] <= k)
                return i;
        return -1;
    }
}