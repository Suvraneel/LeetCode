class Solution {
    private record Node(int dep, int seat) {
    };

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0], maxSeatNum = 0;
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        Queue<Node> occupied = new PriorityQueue<>((a, b) -> a.dep - b.dep);
        Queue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            if (available.isEmpty())
                available.offer(maxSeatNum++);
            while (!occupied.isEmpty() && occupied.peek().dep <= times[i][0])
                available.offer(occupied.poll().seat);
            if (times[i][0] == targetArrival)
                return available.poll();
            occupied.offer(new Node(times[i][1], available.poll()));
        }
        return -1;
    }
}