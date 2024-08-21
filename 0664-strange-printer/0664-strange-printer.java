class Solution {
    public int strangePrinter(String s) {
        String str = removeDuplicates(s);
        char[] S = str.toCharArray();
        int n = S.length;
        int[][] dp = new int[n + 1][n + 1];
        return solve(S, dp, 0, n - 1);
    }

    private String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        char curr = cs[0];
        sb.append(curr);
        for (char c : cs) {
            if (c == curr)
                continue;
            sb.append(c);
            curr = c;
        }
        return sb.toString();
    }

    private int solve(char[] cs, int[][] dp, int lt, int rt) {
        if (lt > rt)
            return 0;
        if (dp[lt][rt] != 0)
            return dp[lt][rt];
        int minTurns = 1 + solve(cs, dp, lt + 1, rt);
        char curr = cs[lt];
        for (int mid = lt + 1; mid <= rt; mid++) {
            if (curr == cs[mid])
                minTurns = Math.min(minTurns,
                        solve(cs, dp, lt, mid - 1) + solve(cs, dp, mid + 1, rt));
        }
        return dp[lt][rt] = minTurns;
    }
}