class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxm = Integer.MIN_VALUE, minm = Integer.MAX_VALUE;
        for (int i : nums) {
            maxm = Math.max(i, maxm);
            minm = Math.min(i, minm);
        }
        return (maxm - minm) * 1l * k;
    }
}