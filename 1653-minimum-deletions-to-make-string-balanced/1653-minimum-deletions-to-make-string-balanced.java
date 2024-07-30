class Solution {
    public int minimumDeletions(String s) {
        char[] S = s.toCharArray();
        int n = S.length, prefixB = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (S[i] == 'a')
                dp[i + 1] = Math.min(dp[i] + 1, prefixB);
            // delete 'a', delete all prefix 'b'(s)
            else {
                dp[i + 1] = dp[i];
                prefixB++;
            }
        }
        return dp[n];
    }
}