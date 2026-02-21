class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int bits = 0, x = i;
            while (x > 0) {
                bits += x & 1;
                x = x >> 1;
            }
            if (isPrime(bits))
                ans++;
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x == 1)
            return false;
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;
        return true;
    }
}