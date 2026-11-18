class Solution {
    public int minChanges(String s) {
        int n = s.length(), flips = 0, prev = s.charAt(0) - '0';
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1))
                flips++;
        }
        return flips;
    }
}