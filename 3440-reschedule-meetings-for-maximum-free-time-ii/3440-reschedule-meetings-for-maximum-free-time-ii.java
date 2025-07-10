class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length, tMax = startTime[0], ans = 0;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = eventTime - endTime[n - 1];
        for (int i = n - 1; i > 0; i--)
            suffixMax[i - 1] = Math.max(suffixMax[i], startTime[i] - endTime[i - 1]);
        for (int i = 1; i < n - 1; i++) {
            if (endTime[i] - startTime[i] <= Math.max(tMax, suffixMax[i + 1])) {
                ans = Math.max(ans, startTime[i + 1] - endTime[i - 1]); // unstable shift (changes relative ordering)
            } else
                ans = Math.max(ans, startTime[i] - endTime[i - 1] + startTime[i + 1] - endTime[i]); // simple slide
            tMax = Math.max(tMax, startTime[i] - endTime[i - 1]);
        }
        // consider flanks as well... added separately to prevent ArrayIndexOutOfBounds errors
        // System.out.println(Arrays.toString(suffixMax));
        // System.out.println(tMax);
        if (endTime[0] - startTime[0] <= suffixMax[1])
            ans = Math.max(ans, startTime[1]);
        else
            ans = Math.max(ans, startTime[0] - 0 + startTime[1] - endTime[0]);
        if (endTime[n - 1] - startTime[n - 1] <= tMax)
            ans = Math.max(ans, eventTime - endTime[n - 2]);
        else
            ans = Math.max(ans, startTime[n - 1] - endTime[n - 2] + eventTime - endTime[n - 1]);
        return ans;
    }
}