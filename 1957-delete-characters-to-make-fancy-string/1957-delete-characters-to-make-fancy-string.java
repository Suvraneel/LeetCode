class Solution {
    public String makeFancyString(String s) {
        int streak = 0;
        char prev = '.';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == prev)
                streak++;
            else {
                prev = c;
                streak = 1;
            }
            if (streak < 3)
                sb.append(c);
        }
        return sb.toString();
    }
}