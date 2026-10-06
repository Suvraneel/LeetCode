class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(')
                stk.push('(');
            else {
                if (!stk.isEmpty())
                    stk.pop();
                else
                    count++; // to make valid s, n(closing) brace upto now must be >= n(opening)
            }
        }
        return count += stk.size(); // remaining opening braces must have counterparts at the end.
    }
}