class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c), s;
        while (a <= b) {
            s = a * a + b * b;
            if (s == c)
                return true;
            else if (s < c)
                a++;
            else
                b--;
        }
        return false;
    }
}