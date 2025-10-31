class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length - 2];
        int[] ans = new int[2];
        int x = 0;
        for (int i : nums) {
            if (seen[i])
                ans[x++] = i;
            seen[i] = true;
        }
        return ans;
    }
}