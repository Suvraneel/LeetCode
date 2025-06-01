class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        limit = Math.min(limit, n);
        for (int i = 0; i <= limit; i++) {
            if (n - i > 2 * limit) // invalid cases
                continue;
            // j_Range => [0, Math.min(n - i, limit)];
            // but again ... k = n - i - j <= limit or n - i - limit <= j
            // so j_range => [Math.max(0, n-i-limit),Math.min(n-i, limit)]
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return Math.max(ans, 0);
    }
}