class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sweep = 0;
        int[] transformationArr = new int[n + 1];
        for (int[] q : queries) {
            transformationArr[q[0]]--;
            transformationArr[q[1] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            sweep += transformationArr[i];
            if (sweep + nums[i] > 0)
                return false;
        }
        return true;
    }
}