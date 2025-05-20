class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, prefixSum = 0;
        int[] diffArr = new int[n + 1];
        for (int[] q : queries) {
            diffArr[q[0]]--;
            diffArr[q[1] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            prefixSum += diffArr[i];
            if (nums[i] + prefixSum > 0)
                return false;
        }
        return true;
    }
}