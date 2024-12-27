class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, maxScore = 0, ltScore = 0;
        for (int i = 1; i < n; i++) {
            ltScore = Math.max(ltScore, values[i - 1] + i);
            maxScore = Math.max(maxScore, ltScore + values[i] - i);
        }
        return maxScore - 1;
    }
}