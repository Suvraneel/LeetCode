class Solution {
    int n;

    public int maxUniqueSplit(String s) {
        this.n = s.length();
        Set<String> seen = new HashSet<>();
        return solve(s, 0, seen);
    }

    private int solve(String s, int idx, Set<String> seen) {
        if (idx == n)
            return 0;
        int maxUniqueSubs = 0;
        for (int i = idx + 1; i <= n; i++) {
            String sub = s.substring(idx, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                maxUniqueSubs = Math.max(1 + solve(s, i, seen), maxUniqueSubs);
                seen.remove(sub);
            }
        }
        return maxUniqueSubs;
    }
}