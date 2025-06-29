class Solution {
    int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); // order doesnt matter
        int n = nums.length, end = n - 1, ans = 0, lt = 0, rt = n - 1;

        // precalculate modded powers of 2
        int[] powersOf2 = new int[n];
        powersOf2[0] = 1;
        for (int i = 1; i < n; i++)
            powersOf2[i] = (powersOf2[i - 1] << 1) % MOD;

        // binary search
        while (lt <= rt) {
            if (nums[lt] + nums[rt] <= target)
                ans = (ans + powersOf2[rt - lt++]) % MOD;
            else
                rt--;

        return ans;
    }
}