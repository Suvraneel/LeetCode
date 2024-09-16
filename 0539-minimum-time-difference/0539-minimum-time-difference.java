class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(), minDiff = Integer.MAX_VALUE;
        int[] timeInMins = new int[n];
        for (int i = 0; i < n; i++) {
            String[] t = timePoints.get(i).split(":");
            timeInMins[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
        Arrays.sort(timeInMins);
        for (int i = 1; i < n; i++)
            minDiff = Math.min(minDiff, timeInMins[i] - timeInMins[i - 1]);
        return minDiff = Math.min(minDiff, 24 * 60 - timeInMins[n-1] + timeInMins[0]);
    }
}