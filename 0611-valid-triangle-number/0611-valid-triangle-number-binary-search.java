class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int lastValidIdx = binarySearch(j, n - 1, nums[i] + nums[j], nums);
                // System.out.println(i + "\t" + j + "\t" + lastValidIdx);
                count += lastValidIdx - j;
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