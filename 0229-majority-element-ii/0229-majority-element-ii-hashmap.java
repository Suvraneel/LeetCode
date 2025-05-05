class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i : nums)
            m.put(i, m.getOrDefault(i, 0) + 1);
        int majorityThreshold = nums.length / 3;
        for (Map.Entry<Integer, Integer> e : m.entrySet())
            if (e.getValue() > majorityThreshold)
                ans.add(e.getKey());
        return ans;
    }
}