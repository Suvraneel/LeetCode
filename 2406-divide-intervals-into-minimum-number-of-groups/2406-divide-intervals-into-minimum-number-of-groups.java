class Solution {
    public int minGroups(int[][] intervals) {
        int minm = Integer.MAX_VALUE, maxm = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            minm = Math.min(minm, interval[0]);
            maxm = Math.max(maxm, interval[1]);
        }
        int[] cal = new int[maxm - minm + 2]; // calendar
        for (int[] interval : intervals) {
            cal[interval[0] - minm]++;
            cal[interval[1] + 1 - minm]--;
        }
        int minDisjointGrp = 0, concurrentInterval = 0;
        for (int i : cal)
            minDisjointGrp = Math.max(minDisjointGrp, concurrentInterval += i);
        // System.out.println(cal);
        return minDisjointGrp;
    }
}