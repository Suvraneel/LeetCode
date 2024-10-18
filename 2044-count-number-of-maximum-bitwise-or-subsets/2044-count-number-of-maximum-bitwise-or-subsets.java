class Solution {
    int[] nums;
    int n, maxOr;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        maxOr = 0;
        for (int i : nums)
            maxOr |= i;
        return solve(0, 0);
    }

    private int solve(int idx, int or) {
        if (idx == n)
            return maxOr == or ? 1 : 0;
        // System.out.println(idx + "\t" + or);
        return solve(idx + 1, or | nums[idx]) + solve(idx + 1, or);
    }
}