class Solution {
    int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); // order doesnt matter
        int n = nums.length, end = n - 1, ans = 0;

        // precalculate modded powers of 2
        int[] powersOf2 = new int[n];
        powersOf2[0] = 1;
        for (int i = 1; i < n; i++)
            powersOf2[i] = (powersOf2[i - 1] << 1) % MOD;

        for (int i = 0; i < n; i++) {
            int bs = binarySearch(nums, i, end, target);
            if (bs < 0)
                break;
            // System.out.println(i + "\t" + bs);
            end = bs; // decrease search space
            ans = (ans + powersOf2[bs - i]) % MOD;
        }
        return ans;
    }

    // find valid key in bounded search space
    private int binarySearch(int[] nums, int lt, int rt, int target) {
        int key = target - nums[lt], bs = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] <= key) {
                bs = mid;
                lt = mid + 1;
            } else
                rt = mid - 1;
        }
        return bs;
    }
}