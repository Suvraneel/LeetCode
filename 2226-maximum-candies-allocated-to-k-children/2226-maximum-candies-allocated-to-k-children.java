class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length, lt = 1, rt = -1, ans = 0;
        for(int c: candies)
            rt = Math.max(rt, c);
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (isValidDistrib(candies, n, k, mid)) {
                ans = mid;
                lt = mid + 1;
            } else
                rt = mid - 1;
        }
        return ans;
    }

    private boolean isValidDistrib(int[] candies, int n, long k, int c) {
        long fed = 0;
        for (int i = n - 1; i >= 0; i--)
            fed += candies[i] / c;
        return fed >= k;
    }
}