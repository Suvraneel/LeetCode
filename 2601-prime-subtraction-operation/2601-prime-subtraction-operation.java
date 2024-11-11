class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        boolean[] primes = sieveOfEratosthenes(nums);
        System.out.println(Arrays.toString(primes));
        int currVal = 1;
        for (int i = 0; i < nums.length;) {
            int diff = nums[i] - currVal;
            if (diff < 0)
                return false;
            if (primes[diff] || diff == 0) {
                i++;
                currVal++;
            } else
                currVal++;
            // System.out.println(Arrays.toString(nums));
        }
        return true;
    }

    private boolean[] sieveOfEratosthenes(int[] nums) {
        int n = nums.length, ceil = 0;
        for (int i : nums)
            ceil = Math.max(ceil, i);
        boolean primes[] = new boolean[ceil + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int curr = 2; curr <= ceil; curr++)
            if (primes[curr])
                for (int multiple = curr * curr; multiple <= ceil; multiple += curr)
                    primes[multiple] = false;
        return primes;
    }
}