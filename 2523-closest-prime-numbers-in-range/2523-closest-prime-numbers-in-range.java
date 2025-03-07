class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = sieveOfEratosthenes(right);
        int prev = -1, minDiff = Integer.MAX_VALUE, a = -1, b = -1;
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (i - prev < minDiff) {
                    a = prev;
                    b = i;
                    minDiff = b - a;
                }
                prev = i;
            }
        }
        if (a == -1)    // if invalid pair
            b = -1;
        return new int[] { a, b };
    }

    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= n; p++)
            if (prime[p])
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
        return prime;
    }
}