class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            int root = (int) Math.sqrt(i);
            if (root * root == i && m.containsKey(root))
                m.put(i, m.get(root) + 1);
            else
                m.put(i, 1);
            ans = Math.max(ans, m.get(i));
        }
        return ans > 1 ? ans : -1;
    }
}