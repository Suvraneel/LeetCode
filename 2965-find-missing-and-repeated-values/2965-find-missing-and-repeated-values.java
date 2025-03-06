class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length, n2 = n * n, sum = 0, sqSum = 0;
        for (int[] r : grid) {
            for (int c : r) {
                sum += c;
                sqSum += c * c;
            }
        }
        long a_minus_b = n2 * (n2 + 1) / 2 - sum;
        long a2_minus_b2 = n2 * (n2 + 1) * (2 * n2 + 1) / 6 - sqSum;
        long a_plus_b = a2_minus_b2 / a_minus_b;
        long a = (a_minus_b + a_plus_b) / 2, b = a_plus_b - a;
        return new int[] { (int) b, (int) a };
    }
}