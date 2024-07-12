class Solution {
    private int score = 0;
    private String str = "";

    private String solve(char c1, char c2, int pts) {
        char[] S = str.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (char c : S) {
            if (c == c1 && !stk.isEmpty() && stk.peek() == c2) {
                stk.pop();
                score += pts;
            } else
                stk.push(c);
            // System.out.println(stk.toString() + "\t" + score);
        }
        StringBuilder remainingString = new StringBuilder();
        while (!stk.isEmpty()) {
            remainingString.append(stk.pop());
        }
        return remainingString.reverse().toString();
    }

    public int maximumGain(String s, int x, int y) {
        str = s;
        if (x < y) {
            str = solve('a', 'b', y);
            solve('b', 'a', x);
        } else {
            str = solve('b', 'a', x);
            solve('a', 'b', y);
        }
        return score;
    }
}