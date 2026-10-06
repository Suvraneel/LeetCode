class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length(), open = 0, count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(')
                open++;
            else {
                if (open > 0)
                    open--;
                else
                    count++; // to make valid s, n(closing) brace upto now must be >= n(opening)
            }
        }
        return count += open; // remaining opening braces must have counterparts at the end.
    }
}