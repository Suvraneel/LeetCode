class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int prev = -1, x = 0;
        int[] ans = new int[2];
        for (int i : nums) {
            if (i == prev)
                ans[x++] = i;
            prev = i;
        }
        return ans;
    }
}