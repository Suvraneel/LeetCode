class Solution {
    public int minMoves(int[] nums) {
        int maxm = 0, sum = 0, n = nums.length;
        for (int i : nums) {
            maxm = Math.max(maxm, i);
            sum += i;
        }
        return maxm * n - sum;
    }
}