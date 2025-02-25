class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007; 
        int n = arr.length, countEvenSum = 1, countOddSum = 0, cumsum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            cumsum += arr[i];
            if (cumsum % 2 == 0) {
                ans += countOddSum;
                countEvenSum++;
            } else {
                ans += countEvenSum;
                countOddSum++;
            }
            ans %= MOD;
        }
        return ans;
    }
}