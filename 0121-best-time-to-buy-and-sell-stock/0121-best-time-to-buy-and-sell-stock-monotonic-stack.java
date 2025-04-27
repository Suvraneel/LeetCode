class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, maxDiff = 0, runningMin = Integer.MAX_VALUE;
        for (int p : prices) {
            runningMin = Math.min(runningMin, p);
            maxDiff = Math.max(maxDiff, p - runningMin);
        }
        return maxDiff;
    }
}