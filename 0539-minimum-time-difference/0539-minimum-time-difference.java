class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(), minDiff = Integer.MAX_VALUE;
        int[] timeInMins = new int[n];
        for (int i = 0; i < n; i++) {
            timeInMins[i] = Integer.parseInt(timePoints.get(i).substring(0,2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(timeInMins);
        for (int i = 1; i < n; i++)
            minDiff = Math.min(minDiff, timeInMins[i] - timeInMins[i - 1]);
        return minDiff = Math.min(minDiff, 24 * 60 - timeInMins[n - 1] + timeInMins[0]);
    }
}