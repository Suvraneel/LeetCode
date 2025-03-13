class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diffArr = new int[n + 1];
        for (int[] q : queries) {
            diffArr[q[0]]--;
            diffArr[q[1] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            diffArr[i + 1] += diffArr[i];
            if (nums[i] + diffArr[i] > 0)
                return false;
        }
        return true;
    }
}