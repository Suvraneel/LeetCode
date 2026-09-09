class Solution {

    public long countCommas(long n) {

        int digits = (int) Math.log10(n) + 1;

        // Correct floating-point rounding near powers of 10
        if (digits > 1 && Math.pow(10, digits - 1) > n) {
            digits--;
        }

        if (digits < 4)
            return 0L;

        if (digits < 7)
            return n - 999L;

        if (digits < 10)
            return 2L * (n - 999_999L)
                    + (999_999L - 999L);

        if (digits < 13)
            return 3L * (n - 999_999_999L)
                    + 2L * (999_999_999L - 999_999L)
                    + (999_999L - 999L);

        if (digits < 16)
            return 4L * (n - 999_999_999_999L)
                    + 3L * (999_999_999_999L - 999_999_999L)
                    + 2L * (999_999_999L - 999_999L)
                    + (999_999L - 999L);

        return 5L * (n - 999_999_999_999_999L)
                + 4L * (999_999_999_999_999L - 999_999_999_999L)
                + 3L * (999_999_999_999L - 999_999_999L)
                + 2L * (999_999_999L - 999_999L)
                + (999_999L - 999L);
    }
}