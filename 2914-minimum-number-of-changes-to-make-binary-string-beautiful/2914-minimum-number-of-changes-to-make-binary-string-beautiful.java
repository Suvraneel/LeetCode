class Solution {
    public int minChanges(String s) {
        int n = s.length(), flips = 0, prev = s.charAt(0) - '0';
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            if (prev != c && (i & 1) == 1)
                flips++;
            prev = c;
        }
        return flips;
    }
}