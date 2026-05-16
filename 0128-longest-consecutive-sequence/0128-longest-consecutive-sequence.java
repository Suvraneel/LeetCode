class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
        int ans = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int streak = 1, prev = i;
                while (set.contains(++prev))
                    streak++;
                ans = Math.max(streak, ans);
            }
        }
        return ans;
    }
}