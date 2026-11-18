class Solution {
    public int minChanges(String s) {
        int n = s.length(), flips = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (prev != c && (i & 1) == 1)
                flips++;
            prev = c;
        }
        return flips;
    }
}