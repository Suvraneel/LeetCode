class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long n = differences.length, variance = 0, minm = 0, maxm = 0, range = 0;
        // lets assume 1st elem is x, then next is x + diff[0], ans so on... 
        // so, minm elem should be lower. Solve for x. Similarly, solve for maxm elem = upper
        for (int i : differences) {
            variance += i;
            minm = Math.min(minm, variance);
            maxm = Math.max(maxm, variance);
        }
        // System.out.println(minm + "\t" + maxm);
        if (maxm - minm > upper - lower)
            return 0;
        return (int) ((upper - maxm) - (lower - minm) + 1);
    }
}