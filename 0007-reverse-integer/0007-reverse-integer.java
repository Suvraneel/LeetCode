class Solution {
    public int reverse(int x) {
        int rev = 0, lastValidNum = Integer.MAX_VALUE / 10;
        boolean negative = x < 0;
        x = Math.abs(x);
        while (x > 0) {
            if (rev > lastValidNum)
                return 0;
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }
        return negative ? -rev : rev;
    }
}