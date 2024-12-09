class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] streak = new int[nums.length];
        boolean[] special = new boolean[queries.length];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] % 2 != nums[i - 1] % 2)
                streak[i] = streak[i - 1] + 1;
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            if (streak[q[1]] - streak[q[0]] == q[1] - q[0])
                special[i] = true;
        }
        return special;
    }
}