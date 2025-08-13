class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        double x = Math.log10(n) / Math.log10(3);
        return x == Math.floor(x);
    }
}