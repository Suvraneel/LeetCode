class Solution {
    public String makeFancyString(String s) {
        char prev = '1';
        int streak = 0;
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c == prev && streak == 2)
                continue;
            else if (c == prev)
                streak++;
            else {
                prev = c;
                streak = 1;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}