class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        TreeSet<Integer> dry = new TreeSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                if (seen.containsKey(rains[i])) {
                    Integer found = dry.ceiling(seen.get(rains[i]));
                    if (found == null)
                        return new int[0];
                    else {
                        ans[found] = rains[i];
                        dry.remove(found);
                    }
                }
                ans[i] = -1;
                seen.put(rains[i], i);
            } else {
                dry.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}