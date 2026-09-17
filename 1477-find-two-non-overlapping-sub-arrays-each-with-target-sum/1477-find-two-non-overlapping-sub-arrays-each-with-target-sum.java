class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, sum = 0, ans = n + 1;
        int[] dp = new int[n + 1]; // smallest valid subarray length so far
        Arrays.fill(dp, n);
        for (int lt = 0, rt = 0; rt < n; rt++) {
            sum += arr[rt];
            while (sum > target)
                sum -= arr[lt++];
            dp[rt + 1] = dp[rt];
            if (sum == target) {
                ans = Math.min(ans, rt - lt + 1 + dp[lt]);
                dp[rt + 1] = Math.min(dp[rt], rt - lt + 1);
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}