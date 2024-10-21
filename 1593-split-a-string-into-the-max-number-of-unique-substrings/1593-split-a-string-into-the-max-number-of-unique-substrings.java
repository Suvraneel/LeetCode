class Solution {
    int maxAns = 0;

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        return solve(s, 0, s.length(), 0, seen);
    }

    private int solve(String s, int idx, int n, int ct, Set<String> seen) {
        if (idx == n)
            return ct;
        if (maxAns > ct + n - idx)
            return 0;
        int maxUniqueSubs = 0;
        for (int i = idx + 1; i <= n; i++) {
            String sub = s.substring(idx, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                maxUniqueSubs = Math.max(solve(s, i, n, ct + 1, seen), maxUniqueSubs);
                seen.remove(sub);
            }
        }
        return maxUniqueSubs;
    }
}