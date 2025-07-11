class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetCt = new int[n];
        Queue<Integer> free = new PriorityQueue<>(IntStream.range(0, n).boxed().toList());
        Queue<long[]> used = new PriorityQueue<>((a, b) -> a[0] != b[0] ?
                Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));   // {meetEndTime, roomNo.}
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for (int[] m : meetings) {
            while (!used.isEmpty() && used.peek()[0] <= m[0])
                free.add((int)used.poll()[1]);
            if (!free.isEmpty()) {
                used.add(new long[]{m[1], free.peek()});    // {meetEndTime, roomNo.}
                meetCt[free.poll()]++;
            } else {
                used.add(new long[]{used.peek()[0] + m[1] - m[0], used.peek()[1]});
                meetCt[(int)used.poll()[1]]++;
            }
//        System.out.println(free.toString());
//        System.out.println(used.toString());
        }
        int maxMeetCt = Integer.MIN_VALUE, ans=-1;
        for (int i = 0; i < n; i++) {
            if (meetCt[i] > maxMeetCt) {
                maxMeetCt = meetCt[i];
                ans = i;
            }
        }
        return ans;
    }
}
