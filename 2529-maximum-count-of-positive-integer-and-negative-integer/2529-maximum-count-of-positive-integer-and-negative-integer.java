class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length, lt = 0, rt = n - 1, neg = n, pos = n;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] < 0)
                lt = mid + 1;
            else {
                rt = mid - 1;
                neg = mid;
            }
        }
        rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] > 0) {
                rt = mid - 1;
                pos = mid;
            } else
                lt = mid + 1;
        }
        // System.out.println(pos + "\t" + neg);
        return Math.max(n - pos, neg);
    }
}