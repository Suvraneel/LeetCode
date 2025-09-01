class Solution {
    private double calcGain(double numerator, double denominator) {
        return (numerator + 1) / (denominator + 1) - numerator / denominator;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2])); // compare gains
        for (int[] c : classes) {
            pq.offer(new double[] { c[0], c[1], calcGain(c[0], c[1]) });
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            pq.offer(new double[] { top[0] + 1, top[1] + 1, calcGain(top[0] + 1, top[1] + 1) });
        }
        double avgRatio = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            avgRatio += top[0] / top[1];
        }
        return avgRatio /= classes.length;
    }
}