class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder quotient = new StringBuilder();
        long dividend = numerator, divisor = denominator;
        if (dividend < 0 || divisor < 0) {
            if (dividend * divisor < 0)
                quotient.append("-");
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
        }
        Map<Long, Integer> repeatingDividend = new HashMap<>(); // sequence -> decimal-th place
        quotient.append(dividend / divisor);
        dividend = (dividend % divisor) * 10;
        if (dividend == 0)
            return quotient.toString();
        quotient.append(".");
        while (dividend > 0) {
            quotient.append(dividend / divisor);
            dividend = (dividend % divisor) * 10;
            if (repeatingDividend.containsKey(dividend)) {
                return quotient.substring(0, repeatingDividend.get(dividend)) + "(" +
                        quotient.substring(repeatingDividend.get(dividend), quotient.length()) + ")";
            }
            repeatingDividend.put(dividend, quotient.length());
        }
        return quotient.toString();
    }
}