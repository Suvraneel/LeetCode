class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, breakpt = -1;
        // inflection / breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpt = i;
                break;
            }
        }
        if (breakpt == -1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - 1 - i];
                nums[n - 1 - i] = temp;
            }
            return;
        }

        // swap
        for (int i = n - 1; i > breakpt; i--)
            if (nums[i] > nums[breakpt]) {
                int temp = nums[i];
                nums[i] = nums[breakpt];
                nums[breakpt] = temp;
                break;
            }
        System.out.println(Arrays.toString(nums));
        // reverse suffix
        for (int i = 1; i <= (n - breakpt) / 2; i++) {
            int temp = nums[breakpt + i];
            nums[breakpt + i] = nums[n - i];
            nums[n - i] = temp;
        }
    }
}