class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long len = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '*' -> {
                    if (len > 0)
                        len--;
                }
                case '#' -> len *= 2;
                case '%' -> {
                }
                default -> len++;
            }
        }
        if (k + 1 > len)
            return '.';
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case '*' -> len++;
                case '#' -> {
                    if (k + 1 > (len + 1) / 2)
                        k -= len / 2;
                    len = (len + 1) / 2;
                }
                case '%' -> k = len - k - 1;
                default -> {
                    if (k + 1 == len)
                        return c;
                    len--;
                }
            }
        }
        return '.';
    }
}