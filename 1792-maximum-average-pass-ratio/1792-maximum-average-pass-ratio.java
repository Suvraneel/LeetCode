class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> passRatios = new PriorityQueue<>((a, b) -> Double.compare(
                ((double) (b[0] + 1d) / (b[1] + 1d) - (double) b[0] / b[1]),
                ((double) (a[0] + 1d) / (a[1] + 1d) - (double) a[0] / a[1])));
        for (int[] c : classes)
            passRatios.offer(new double[] { c[0], c[1] });
        while (extraStudents-- > 0) {
            double[] smallestPR = passRatios.poll();
            smallestPR[0]++;
            smallestPR[1]++;
            passRatios.offer(smallestPR);
        }
        double maxAvgRatio = 0d;
        while (!passRatios.isEmpty()) {
            double[] smallestPR = passRatios.poll();
            maxAvgRatio += smallestPR[0] / smallestPR[1];
        }
        return maxAvgRatio / classes.length;
    }
}