class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[lt] <= nums[mid]) {
                if (target >= nums[lt] && target < nums[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[rt]) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }
        return -1;
    }
}