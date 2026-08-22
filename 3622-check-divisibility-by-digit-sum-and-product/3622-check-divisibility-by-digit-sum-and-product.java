class Solution {
    public boolean checkDivisibility(int n) {
        int x = n, sum = 0, pdt = 1;
        while (x > 0) {
            int d = x % 10;
            sum += d;
            pdt *= d;
            x /= 10;
        }
        return n % (sum + pdt) == 0;
    }
}