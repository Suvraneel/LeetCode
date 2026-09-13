class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> spacing = new HashMap<>();
        Set<Integer> impossible = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int F = freq.getOrDefault(nums[i], 0);
            freq.put(nums[i], ++F);
            if (F == 2)
                spacing.put(nums[i], i - last.get(nums[i]));
            else if (F > 2 && spacing.get(nums[i]) != i - last.get(nums[i]))
                impossible.add(nums[i]);
            last.put(nums[i], i);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet())
            if (e.getValue() >= 3 && !impossible.contains(e.getKey()))
                ans++;
        return ans;
    }
}