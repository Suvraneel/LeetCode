class Solution {
    int maxUniqueSubstrings = 0;

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        solve(s, 0, s.length(), 0, seen);
        return maxUniqueSubstrings;
    }

    private void solve(String s, int idx, int n, int ct, Set<String> seen) {
        if (idx == n) {
            maxUniqueSubstrings = Math.max(maxUniqueSubstrings, ct);
            return;
        }
        if (maxUniqueSubstrings > ct + n - idx)
            return;
        for (int i = idx + 1; i <= n; i++) {
            String sub = s.substring(idx, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                solve(s, i, n, ct + 1, seen);
                seen.remove(sub);
            }
        }
    }
}