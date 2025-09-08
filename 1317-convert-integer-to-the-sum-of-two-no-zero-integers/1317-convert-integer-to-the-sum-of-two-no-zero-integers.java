class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (isNoZeroInteger(i) && isNoZeroInteger(n - i))
                return new int[] { i, n - i };
        }
        return new int[2];
    }

    private boolean isNoZeroInteger(int x) {
        while (x > 0) {
            if (x % 10 == 0)
                return false;
            x /= 10;
        }
        return true;
    }
}