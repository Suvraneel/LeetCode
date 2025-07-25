class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, maxm = Integer.MIN_VALUE;
        for (int i : nums) {
            maxm = Math.max(maxm, i);
            if (i > 0 && !set.contains(i)) {
                sum += i;
                set.add(i);
            }
        }
        return set.size() == 0 ? maxm : sum;
    }
}