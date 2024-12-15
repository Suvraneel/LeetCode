class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<int[]> passRatios = new PriorityQueue<>((a, b) -> Double.compare(
                ((b[0] + 1d) / (b[1] + 1d) - (double) b[0] / b[1]),
                ((a[0] + 1d) / (a[1] + 1d) - (double) a[0] / a[1])));
        for (int[] c : classes)
            passRatios.offer(c);
        while (extraStudents-- > 0) {
            int[] smallestPR = passRatios.poll();
            smallestPR[0]++;
            smallestPR[1]++;
            passRatios.offer(smallestPR);
        }
        double maxAvgRatio = 0d;
        while (!passRatios.isEmpty()) {
            int[] smallestPR = passRatios.poll();
            maxAvgRatio += (double)smallestPR[0] / smallestPR[1];
        }
        return maxAvgRatio / classes.length;
    }
}