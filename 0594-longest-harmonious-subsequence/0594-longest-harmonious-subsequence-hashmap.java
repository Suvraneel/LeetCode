class Solution {
    public int findLHS(int[] nums) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            len = Math.max(len, map.getOrDefault(e.getKey() + 1, Integer.MIN_VALUE) + e.getValue());
        return len;
    }
}