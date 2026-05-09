class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, lt = 0;
        long cumsum = 0;
        for (int rt = 0; rt < n; rt++) {
            int tgt = nums[rt];
            cumsum += tgt;
            if ((rt - lt + 1l) * tgt - cumsum > k)
                cumsum -= nums[lt++];
        }
        return n - lt;
    }
}