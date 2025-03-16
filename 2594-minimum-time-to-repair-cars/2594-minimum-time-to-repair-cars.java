class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minTime = 1, maxTime = 100L * cars * cars;
        while (minTime < maxTime) {
            long midTime = (minTime + maxTime) / 2;
            if (canRepair(ranks, cars, midTime)) {
                maxTime = midTime;
            } else {
                minTime = midTime + 1;
            }
        }
        return maxTime;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        long carsRepaired = 0;
        for (int r : ranks)
            carsRepaired += (long) Math.sqrt((long) (time / r));
        // System.out.println(time + "\t" + carsRepaired);
        return carsRepaired >= cars;
    }
}