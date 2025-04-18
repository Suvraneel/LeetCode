class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        return solve(s, 0, s.length() - 1);
    }

    private boolean solve(String s, int lt, int rt) {
        while (lt < rt && !isAlphanumeric(s.charAt(lt)))
            lt++;
        while (lt < rt && !isAlphanumeric(s.charAt(rt)))
            rt--;
        if (lt < rt) {
            System.out.println(s.charAt(lt) + "\t" + s.charAt(rt));
            if (s.charAt(lt) != s.charAt(rt))
                return false;
            return solve(s, lt + 1, rt - 1);
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}