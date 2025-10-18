class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE, distinct = 0;
        for (int n : nums) {
            if (prev == n + k)
                continue;
            prev = Math.max(prev + 1, n - k);
            distinct++;
        }
        return distinct;
    }
}