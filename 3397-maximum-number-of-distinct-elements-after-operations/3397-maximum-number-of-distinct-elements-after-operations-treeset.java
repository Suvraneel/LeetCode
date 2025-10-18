class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MIN_VALUE);
        for (int n : nums)
            set.add(Math.min(Math.max(set.last() + 1, n - k), n + k));
        set.remove(Integer.MIN_VALUE);
        // System.out.println(set);
        return set.size();
    }
}