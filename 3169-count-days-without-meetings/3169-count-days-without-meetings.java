class Solution {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> calendar = new TreeMap<>();
        for (int[] m : meetings) {
            calendar.put(m[0], calendar.getOrDefault(m[0], 0) + 1);
            calendar.put(m[1] + 1, calendar.getOrDefault(m[1] + 1, 0) - 1);
        }
        int concurrentMeets = 0, prevDay = calendar.firstKey(), freeDays = calendar.firstKey();
        for (Map.Entry<Integer, Integer> e : calendar.entrySet()) {
            if (concurrentMeets == 0){
                freeDays += e.getKey() - prevDay;
            }
            concurrentMeets += e.getValue();
            prevDay = e.getKey();
        }
        return freeDays + days - prevDay;
    }
}