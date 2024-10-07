class Solution {
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stk.isEmpty())
                stk.push(c);
            else if ((c == 'B' && stk.peek() == 'A')
                    || (c == 'D' && stk.peek() == 'C'))
                stk.pop();
            else
                stk.push(c);
        }
        return stk.size();
    }
}