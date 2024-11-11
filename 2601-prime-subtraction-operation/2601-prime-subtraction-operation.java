class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        boolean[] primes = sieveOfEratosthenes(nums);
        // System.out.println(Arrays.toString(primes));
        int currVal = 1;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - currVal;
            for (int j = diff - 1; j >= 0; j--)
                if (primes[j]) {
                    nums[i] -= j;
                    break;
                }
            currVal = nums[i];
            // System.out.println(Arrays.toString(nums));
        }
        for (int i = 1; i < nums.length - 1; i++)
            if (nums[i] <= nums[i - 1] || nums[i] >= nums[i + 1])
                return false;
        return n > 2 ? true : nums[1] > nums[0];
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