class Solution {
    public int maxProduct(int n) {
        int a = 0, b = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            if (a <= d) {
                b = a;
                a = d;
            } else if (b < d)
                b = d;
        }
        return a * b;
    }
}