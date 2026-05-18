class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length, lt = 0, rt = n - 1;
        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (nums[mid] < nums[mid + 1])
                lt = mid + 1;
            else
                rt = mid;
        }
        return rt;
    }
}