class Solution {
    public int findLHS(int[] nums) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            if (map.containsKey(e.getKey() + 1))
                len = Math.max(len, map.get(e.getKey() + 1) + e.getValue());
        return len;
    }
}