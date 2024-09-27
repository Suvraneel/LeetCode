class MyCalendarTwo {
    TreeMap<Integer, Integer> bookings;
    int maxPermissibleOverlaps;

    public MyCalendarTwo() {
        bookings = new TreeMap<>();
        maxPermissibleOverlaps = 2;
    }

    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);
        if (bookings.get(end) == 0)
            bookings.remove(end);
        // Calc prefix sum
        int concurrentOverlaps = 0;
        for (Map.Entry<Integer, Integer> e : bookings.entrySet()) {
            concurrentOverlaps += e.getValue();
            if (concurrentOverlaps > maxPermissibleOverlaps) {
                // Rollback
                bookings.put(start, bookings.getOrDefault(start, 0) - 1);
                bookings.put(end, bookings.getOrDefault(end, 0) + 1);
                // Clean up
                if (bookings.get(start) == 0)
                    bookings.remove(start);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */