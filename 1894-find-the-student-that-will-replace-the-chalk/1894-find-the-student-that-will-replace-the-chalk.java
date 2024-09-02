class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long cumsum = 0;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i-1] + chalk[i];
        k %= prefixSum[n - 1];
        for (int i = 0; i < n; i++)
            if (prefixSum[i] > k)
                return i;
        return n - 1;
    }
}