class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] prefixGap = new int[n + 1];
        prefixGap[0] = startTime[0];
        int prev = endTime[0];
        for (int i = 1; i < n; i++) {
            prefixGap[i] = prefixGap[i - 1] + startTime[i] - prev;
            prev = endTime[i];
        }
        prefixGap[n] = prefixGap[n - 1] + eventTime - prev;
        // System.out.println(Arrays.toString(prefixGap));
        int ans = prefixGap[k];
        for (int i = k + 1; i <= n; i++)
            ans = Math.max(ans, prefixGap[i] - prefixGap[i - k - 1]);
        return ans;
    }
}