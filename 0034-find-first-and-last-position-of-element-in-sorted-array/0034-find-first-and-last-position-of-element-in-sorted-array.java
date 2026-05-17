class Solution {
    private int solveForStart(int[] nums, int lt, int rt, int target) {
        int ans = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] < target)
                lt = mid + 1;
            else if (nums[mid] >= target) {
                if (nums[mid] == target)
                    ans = mid;
                rt = mid - 1;
            }
        }
        return ans;
    }

    private int solveForEnd(int[] nums, int lt, int rt, int target) {
        int ans = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target)
                    ans = mid;
                lt = mid + 1;
            } else if (nums[mid] > target)
                rt = mid - 1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = solveForStart(nums, 0, nums.length - 1, target);
        ans[1] = solveForEnd(nums, 0, nums.length - 1, target);
        return ans;
    }
}