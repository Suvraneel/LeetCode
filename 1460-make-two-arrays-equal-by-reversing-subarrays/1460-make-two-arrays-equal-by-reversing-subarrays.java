class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : target)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : arr) {
            if (!freq.containsKey(i))
                return false;
            freq.put(i, freq.get(i) - 1);
            if (freq.get(i) == 0)
                freq.remove(i);
        }
        return freq.size() == 0;
    }
}