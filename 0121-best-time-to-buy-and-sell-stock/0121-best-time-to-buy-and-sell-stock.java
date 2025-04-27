class Solution {
    public int maxProfit(int[] prices) {
        int minYet = Integer.MAX_VALUE, maxProfit = 0;
        for (int p : prices) {
            minYet = Math.min(minYet, p);
            maxProfit = Math.max(maxProfit, p - minYet);
        }
        return maxProfit;
    }
}