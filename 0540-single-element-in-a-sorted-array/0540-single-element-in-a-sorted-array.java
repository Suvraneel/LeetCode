class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, lt = 0, rt = n - 1;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1])
                    lt = mid + 1;
                else
                    rt = mid - 1;
            } else {
                if (nums[mid] == nums[mid + 1])
                    lt = mid + 2;
                else
                    rt = mid;
            }
        }
        return nums[rt];
    }
}