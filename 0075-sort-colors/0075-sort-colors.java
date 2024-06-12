class Solution {
    public void sortColors(int[] nums) {
        int[] colorsFreq = new int[3];
        for (int i : nums)
            colorsFreq[i]++;
        for (int c = 0, i = 0; c < 3; c++)
            while (colorsFreq[c]-- > 0)
                nums[i++] = c;
    }
}