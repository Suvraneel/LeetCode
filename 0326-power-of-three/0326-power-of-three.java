class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        double x = Math.log(n) / Math.log(3);
        return x == Math.floor(x);
    }
}