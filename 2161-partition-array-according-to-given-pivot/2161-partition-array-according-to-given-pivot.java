class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, lt = 0, lr = 0, ct = 0;
        int[] larger = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot)
                ct++;
            else if (nums[i] > pivot)
                larger[lr++] = nums[i];
            else
                nums[lt++] = nums[i];
        }
        while (ct-- > 0)
            nums[lt++] = pivot;
        lr = 0;
        while (lt < n)
            nums[lt++] = larger[lr++];
        return nums;
    }
}