class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        while (n > 2) {
            s = sb.toString();
            sb.setLength(0);
            for (int i = 0; i < n - 1; i++)
                sb.append((s.charAt(i) + s.charAt(i + 1) - 2 * '0') % 10);
            n = sb.length();
            // System.out.println(sb);
        }
        return sb.charAt(0) == sb.charAt(1);
    }
}