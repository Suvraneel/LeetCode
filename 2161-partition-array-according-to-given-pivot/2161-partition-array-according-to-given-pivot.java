class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, i = 0, j = n - 1;
        int[] ans = new int[n];
        for (int lt = 0, rt = n - 1; lt < n; lt++, rt--) {
            if (nums[lt] < pivot)
                ans[i++] = nums[lt];
            if (nums[rt] > pivot)
                ans[j--] = nums[rt];
        }
        while (i <= j)
            ans[i++] = pivot;
        return ans;
    }
}