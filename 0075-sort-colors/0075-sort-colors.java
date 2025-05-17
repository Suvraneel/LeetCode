class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int i : nums)
            freq[i]++;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (freq[0]-- > 0)
                nums[i] = 0;
            else if (freq[1]-- > 0)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}