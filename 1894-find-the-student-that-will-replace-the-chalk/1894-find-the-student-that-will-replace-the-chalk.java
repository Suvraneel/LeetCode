class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
        k %= prefixSum[n - 1];
        int lt = 0, rt = n - 1;
        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (prefixSum[mid] > k)
                rt = mid;
            else
                lt = mid + 1;
        }
        return rt;
    }
}