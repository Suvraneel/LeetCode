class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '*' -> sb.setLength(Math.max(0, sb.length() - 1));
                case '#' -> sb.append(sb.toString());
                case '%' -> sb.reverse();
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }
}