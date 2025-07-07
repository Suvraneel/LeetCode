class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length, ans = 0, maxDay = Arrays.stream(events).mapToInt(e -> e[1]).max().orElse(0);
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int d = 0, e = 0; d <= maxDay; d++) {
            while (e < n && events[e][0] <= d)
                minHeap.offer(events[e++][1]);
            while (!minHeap.isEmpty() && minHeap.peek() < d) // missed events
                minHeap.poll();
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                ans++;
            }
        }
        return ans;
    }
}