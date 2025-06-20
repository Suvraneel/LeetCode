class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N' -> y++;
                case 'E' -> x++;
                case 'W' -> x--;
                case 'S' -> y--;
            }
            ans = Math.max(ans, Math.min(Math.abs(x) + Math.abs(y) + k * 2, i + 1));
        }
        return ans;
    }
}