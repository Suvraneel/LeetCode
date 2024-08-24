class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length(), mid = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long N = Long.valueOf(n), firstHalf = Long.valueOf(n.substring(0, mid + 1));
        long[] pals = new long[5];
        pals[0] = makePalindrome(firstHalf, len % 2 == 1);
        pals[1] = makePalindrome(firstHalf - 1, len % 2 == 1);
        pals[2] = makePalindrome(firstHalf + 1, len % 2 == 1);
        pals[3] = (long) Math.pow(10, len - 1) - 1;
        pals[4] = (long) Math.pow(10, len) + 1;
        // System.out.println(Arrays.toString(pals));
        long minDiff = Long.MAX_VALUE, ans = pals[0];
        for (long p : pals) {
            if (p == N)
                continue;
            long currDiff = Math.abs(N - p);
            if (minDiff > currDiff) {
                minDiff = currDiff;
                ans = p;
            } else if (minDiff == currDiff) {
                ans = Math.min(ans, p);
            }
        }
        return String.valueOf(ans);
    }

    private long makePalindrome(long half, boolean odd) {
        long pal = half;
        if (odd)
            half /= 10;
        while (half > 0) {
            pal = pal * 10 + (half % 10);
            half /= 10;
        }
        return pal;
    }
}