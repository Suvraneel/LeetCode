class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stk = new Stack<>();
        int ans = 0;
        char prevChar = '.';
        for (char c : directions.toCharArray()) {
            if (c == prevChar || c == 'R' || stk.isEmpty() || stk.peek() == 'L')
                stk.push(c);
            else {
                char top = stk.pop();
                if (top == 'S' || c == 'S')
                    ans++;
                else
                    ans += 2;
                stk.push(c = 'S');
            }
            System.out.println(stk + "\t" + ans);
            prevChar = c;
        }
        return ans;
    }
}