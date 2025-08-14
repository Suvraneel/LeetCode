class Solution {
    public String largestGoodInteger(String num) {
        int[] freq = new int[10];
        int prev = -1, ansDigit = -1;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (digit == prev) {
                if (++freq[digit] == 3)
                    ansDigit = Math.max(ansDigit, digit);
            } else {
                freq[digit] = 1;
                prev = digit;
            }
        }
        return ansDigit == -1 ? "" : "" + ansDigit + ansDigit + ansDigit;
    }
}