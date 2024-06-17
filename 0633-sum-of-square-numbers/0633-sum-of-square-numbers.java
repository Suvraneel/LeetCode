class Solution {
    public boolean judgeSquareSum(int c) {
        double b = Math.sqrt(c);
        for (int a = 0; a <= b; a++) {
            b = Math.sqrt(c - a * a);
            if (b == Math.floor(b))
                return true;
        }
        return false;
    }
}