class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')' -> {
                    if (!stk.isEmpty() && stk.peek() == '(')
                        stk.pop();
                    else
                        return false;
                }
                case '}' -> {
                    if (!stk.isEmpty() && stk.peek() == '{')
                        stk.pop();
                    else
                        return false;
                }
                case ']' -> {
                    if (!stk.isEmpty() && stk.peek() == '[')
                        stk.pop();
                    else
                        return false;
                }
                default -> stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}