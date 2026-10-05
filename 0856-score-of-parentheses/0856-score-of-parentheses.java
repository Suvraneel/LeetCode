class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stk.push(-1);
            } else {
                if (stk.peek() == -1) {
                    stk.pop();
                    stk.push(1);
                } else {
                    int sum = 0;
                    while (stk.peek() != -1)
                        sum += stk.pop();
                    stk.pop(); // rm ( and put 2 * sum
                    stk.push(2 * sum);
                }
            }
        }
        int ans = 0;
        while (!stk.isEmpty())
            ans += stk.pop();
        return ans;
    }
}