class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0, n = nums.length, count = 0;
        while (i < n && nums[i] == 0)
            i++;
        for (; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }

    private int binarySearch(int lt, int rt, int target, int[] nums) {
        int idx = lt;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] >= target)
                rt = mid - 1;
            else {
                idx = mid;
                lt = mid + 1;
            }
        }
        return idx;
    }
}