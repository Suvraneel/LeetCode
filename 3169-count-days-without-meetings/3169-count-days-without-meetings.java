class Solution {
    public int countDays(int days, int[][] meetings) {
        Map<Integer, Integer> calendar = new TreeMap<>();
        for (int[] m : meetings) {
            calendar.put(m[0], calendar.getOrDefault(m[0], 0) + 1);
            calendar.put(m[0], calendar.getOrDefault(m[0], 0) - 1);
        }
        int concurrentMeets = 0, freeDays = 0;
        for (int c : calendar.values()) {
            concurrentMeets += c;
            if (concurrentMeets == 0)
                freeDays++;
        }
        return freeDays - 1;
    }
}