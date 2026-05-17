class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[lt] <= nums[mid]) {
                if (nums[lt] <= target && target < nums[mid])
                    rt = mid - 1;
                else
                    lt = mid + 1;
            } else if (nums[mid] <= nums[rt]) {
                if (nums[mid] < target && target <= nums[rt])
                    lt = mid + 1;
                else
                    rt = mid - 1;
            }
        }
        return -1;
    }
}