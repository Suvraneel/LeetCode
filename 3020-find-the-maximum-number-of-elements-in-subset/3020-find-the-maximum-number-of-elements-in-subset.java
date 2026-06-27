class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        Map<Integer, Integer> series = new HashMap<>();
        int maxm = 0, oneCt = freq.getOrDefault(1, 0);
        if (oneCt > 0)
            freq.remove(1);
        for (Map.Entry<Integer, Integer> e : freq.entrySet())
            maxm = Math.max(maxm, solve(e.getKey(), e.getValue(), freq, series, 1));
        // System.out.println(series);
        return Math.max(maxm * 2 - 1, (oneCt & 1) == 1 ? oneCt : oneCt - 1);
    }

    int solve(int key, int val, Map<Integer, Integer> freq, Map<Integer, Integer> series, int depth) {
        if (series.containsKey(key))
            return series.get(key);
        if (val == 0)
            return 0;
        int sq = key * key;
        if (val >= 2 && freq.containsKey(sq)) {
            depth = solve(sq, freq.get(sq), freq, series, depth) + 1;
            series.put(key, depth);
            return depth;
        }
        // val == 1 or (val>=2 but square not present)
        series.put(key, 1);
        return 1;
    }
}