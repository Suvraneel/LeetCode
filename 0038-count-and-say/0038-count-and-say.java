class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (--n > 0)
            s = solve(s);
        return s;
    }

    private String solve(String s) {
        char prev = s.charAt(0);
        int ct = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                sb.append(ct).append(prev);
                prev = c;
                ct = 1;
            } else
                ct++;
        }
        sb.append(ct).append(prev);
        // System.out.println(sb);
        return sb.toString();
    }
}