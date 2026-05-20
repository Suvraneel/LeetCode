class Solution {
    public double myPow(double x, int n) {
        if (x == 1)
            return 1;
        if (n < 0)
            return pow(1d / x, -(long) n);
        return pow(x, n);
    }

    private double pow(double x, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        return x * pow(x, n - 1);
    }
}