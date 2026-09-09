class Solution {

    public long countCommas(long n) {
        long lt = 1000, rt, commaCt = 1, ans = 0;
        while (lt <= n) {
            rt = Math.min(n, lt * 1000 - 1);
            ans += commaCt * (rt - lt + 1);
            lt *= 1000;
            commaCt++;
        }
        return ans;
    }
}