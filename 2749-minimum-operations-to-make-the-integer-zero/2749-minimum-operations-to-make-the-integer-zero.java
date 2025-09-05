class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long rem = num1 - (long) num2 * i;
            if (rem < i)
                return -1;
            if (i >= Long.bitCount(rem)) // since we can substract as many (2^0 + num2) from num1 as needed
                return i;
        }
        return -1;
    }
}