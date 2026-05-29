class Solution {
    public int minElement(int[] nums) {
        int minm = Integer.MAX_VALUE;
        for (int n : nums)
            minm = Math.min(minm, sumOfDigits(n));
        return minm;
    }

    int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}