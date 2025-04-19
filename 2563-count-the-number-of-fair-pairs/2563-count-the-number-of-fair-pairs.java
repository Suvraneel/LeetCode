class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length, lt = 1, rt = n - 1;
        long ans = 0;
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n - 1; i++) {
            rt = findWindowEnd(nums, upper - nums[i], i + 1, rt);
            if (nums[i] + nums[rt] < lower)
                continue;
            lt = findWindowStart(nums, lower - nums[i], i + 1, rt);
            if (nums[i] + nums[lt] > upper)
                continue;
            // System.out.println(nums[i] + "\t" + nums[lt] + "\t" + nums[rt]);
            ans += rt - lt + 1;
        }
        return ans;
    }

    private int findWindowStart(int[] nums, int target, int lt, int rt) {
        int ans = lt;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] < target)
                lt = mid + 1;
            else {
                ans = mid;
                rt = mid - 1;
            }
        }
        return ans;
    }

    private int findWindowEnd(int[] nums, int target, int lt, int rt) {
        int ans = rt;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] > target)
                rt = mid - 1;
            else {
                ans = mid;
                lt = mid + 1;
            }
        }
        return ans;
    }
}