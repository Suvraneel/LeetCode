class Solution {
    private double calcGain(double[] a) {
        return (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(calcGain(b), calcGain(a)));
        for (int[] c : classes)
            pq.offer(new double[] { c[0], c[1] });
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            pq.offer(new double[] { top[0] + 1, top[1] + 1 });
        }
        double avgRatio = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            avgRatio += top[0] / top[1];
        }
        return avgRatio /= classes.length;
    }
}