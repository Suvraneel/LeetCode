class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), nextA = n, nextB = n, nextC = n, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += n - Math.max(nextA, Math.max(nextB, nextC));
            switch (s.charAt(i)) {
                case 'a' -> nextA = i;
                case 'b' -> nextB = i;
                case 'c' -> nextC = i;
            }
        }
        ans += n - Math.max(nextA, Math.max(nextB, nextC));
        return ans;
    }
}