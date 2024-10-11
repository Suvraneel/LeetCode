class Solution {
    private record Node(int dep, int seat) {
    };

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0], maxSeatNum = 0;
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        Queue<Node> occupied = new PriorityQueue<>((a, b) -> a.dep - b.dep);
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < times.length; i++) {
            while (!occupied.isEmpty() && occupied.peek().dep <= times[i][0])
                available.add(occupied.poll().seat);
            if (available.isEmpty())
                available.add(maxSeatNum++);
            if (times[i][0] == targetArrival)
                return available.first();
            occupied.offer(new Node(times[i][1], available.first()));
            available.remove(available.first());
        }
        return -1;
    }
}