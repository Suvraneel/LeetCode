class Solution {
    public int differenceOfSums(int n, int m) {
        int mul = n / m; // num of multiples within range [1, n]
        // num2 = (`mul` natural number sum) * m = (n / m * (n / m + 1) / 2) * m
        // num1 = totalSum of n natural nums - num2
        // num1 - num2 = totalSum of n natural nos. - 2 * num2
        //             = n * (n + 1) / 2 - 2 * mul * (mul + 1) / 2 * m
        return n * (n + 1) / 2 - mul * (mul + 1) * m;
    }
}