class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, maxDiff = 0, minYet = Integer.MAX_VALUE;
        for (int p : prices) {
            minYet = Math.min(minYet, p);
            maxDiff = Math.max(maxDiff, p - minYet);
        }
        return maxDiff;
    }
}