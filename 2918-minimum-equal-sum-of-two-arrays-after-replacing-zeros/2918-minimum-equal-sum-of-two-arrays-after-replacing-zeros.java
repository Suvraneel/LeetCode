class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int ctZero1 = 0, ctZero2 = 0;
        for (int i : nums1) {
            if (i == 0)
                ctZero1++;
            else
                sum1 += i;
        }
        sum1 += ctZero1;
        for (int i : nums2) {
            if (i == 0)
                ctZero2++;
            else
                sum2 += i;
        }
        sum2 += ctZero2;
        if ((sum1 > sum2 && ctZero2 == 0) || (sum1 < sum2 && ctZero1 == 0))
            return -1;
        return Math.max(sum1, sum2);
    }
}