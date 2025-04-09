class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] seen = new boolean[101];
        int ops = 0;
        seen[k] = true;
        for (int i : nums)
            if (i < k)
                return -1;
            else if (!seen[i]) {
                seen[i] = true;
                ops++;
            }
        return ops;
    }
}