class Solution {
    private double calcGain(int[] a) {
        return 1d * (a[0] + 1) / (a[1] + 1) - 1d * a[0] / a[1];
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(calcGain(b), calcGain(a)));
        for (int[] c : classes)
            pq.offer(c);
        while (extraStudents-- > 0) {
            int[] top = pq.poll();
            pq.offer(new int[] { top[0] + 1, top[1] + 1 });
        }
        double avgRatio = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            avgRatio += 1d * top[0] / top[1];
        }
        return avgRatio /= classes.length;
    }
}