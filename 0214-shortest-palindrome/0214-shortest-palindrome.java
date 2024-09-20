class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        for (int i = n; i > 0; i--) {
            String x = s.substring(0, i);
            if (isPalindrome(x)) {
                // System.out.println(x);
                StringBuilder sb = new StringBuilder(s.substring(i));
                sb.reverse();
                sb.append(s);
                return sb.toString();
            }
        }
        return s;
    }

    private boolean isPalindrome(String s) {
        int sz = s.length();
        for (int lt = 0, rt = sz - 1; lt < rt; lt++, rt--)
            if (s.charAt(lt) != s.charAt(rt))
                return false;
        return true;
    }
}