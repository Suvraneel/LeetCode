class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
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