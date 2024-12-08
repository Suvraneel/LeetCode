class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int[]> lineSweep = new ArrayList<>();
        for (int[] e : events) {
            lineSweep.add(new int[] { e[0], 1, e[2] }); // start of interval
            lineSweep.add(new int[] { e[1] + 1, -1, e[2] });    // end of interval
        }
        lineSweep.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int maxVal = 0, ans = 0;
        for (int[] t : lineSweep) {
            if (t[1] == 1) {
                ans = Math.max(ans, t[2] + maxVal); // sum of curr & max val of prev ended non-overlapped
            } else
                maxVal = Math.max(maxVal, t[2]); // track max non-overlapped value in line yet
        }
        return ans;
    }
}