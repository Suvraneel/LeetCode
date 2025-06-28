class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] store = new int[n][2];
        for (int i = 0; i < n; i++)
            store[i] = new int[] { nums[i], i };
        Arrays.sort(store, (a, b) -> b[0] - a[0]);
        Arrays.sort(store, 0, k, (a, b) -> a[1] - b[1]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = store[i][0];
        return ans;
    }
}