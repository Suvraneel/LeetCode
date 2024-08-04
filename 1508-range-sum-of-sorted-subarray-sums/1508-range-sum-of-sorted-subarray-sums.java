class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int idx = 0;
        int[] arr = new int[n * (n + 1) / 2];
        arr[0] = nums[0];
        for (int i = 1; i < n; i++)
            arr[++idx] = nums[i] += nums[i - 1];
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                arr[++idx] = nums[j] - nums[i]; // subarray sum
        // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int mod = (int) 1e9 + 7, sum = 0;
        for (int i = left - 1; i < right; i++)
            sum = (sum + arr[i]) % mod;
        return sum;
    }
}