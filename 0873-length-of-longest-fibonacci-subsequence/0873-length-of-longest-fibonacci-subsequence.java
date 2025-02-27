class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, maxStreak = 0;
        int[][] dp = new int[n][n];
        for (int curr = 2; curr < n; curr++) {
            int lt = 0, rt = curr - 1;
            while (lt < rt) {
                int sum = arr[lt] + arr[rt];
                if (sum > arr[curr])
                    rt--;
                else if (sum < arr[curr])
                    lt++;
                else {
                    dp[rt][curr] = dp[lt][rt] + 1; // streak inc.
                    maxStreak = Math.max(maxStreak, dp[rt][curr]);
                    rt--;
                    lt++;
                }
            }
        }
        return maxStreak == 0 ? 0 : maxStreak + 2;
    }
}