class Solution {
    public int minGroups(int[][] intervals) {
        Map<Integer, Integer> cal = new TreeMap<>(); // calendar
        for (int[] interval : intervals) {
            cal.put(interval[0], cal.getOrDefault((interval[0]), 0) + 1);
            cal.put(interval[1] + 1, cal.getOrDefault(interval[1] + 1, 0) - 1);
        }
        int minDisjointGrp = 0, concurrentInterval = 0;
        for(Integer e: cal.values())
            minDisjointGrp = Math.max(minDisjointGrp, concurrentInterval += e);
        // System.out.println(cal);
        return minDisjointGrp;
    }
}