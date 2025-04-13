class Solution {
    int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long oddPosns = n / 2;
        long evenPosns = (n & 1) == 1 ? oddPosns + 1 : oddPosns;
        return (int) ((moduloPower(5, evenPosns) * moduloPower(4, oddPosns)) % MOD);
    }

    private long moduloPower(int base, long exp) {
        long res = 1;
        while (exp-- > 0)
            res = (res * base) % MOD;
        return res;
    }
}