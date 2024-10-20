class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stk = new Stack<>();
        for (char c : expression.toCharArray()) {
            // System.out.println(stk);
            if (c == ')') {
                List<Boolean> operands = new ArrayList<>();
                char o = stk.pop();
                while (o != '(') {
                    operands.add(o == 't' ? true : false);
                    o = stk.pop();
                }
                o = stk.pop(); // operator
                boolean res = false;
                switch (o) {
                    case '!' -> res = !operands.get(0);
                    case '|' -> {
                        res = false;
                        for (boolean b : operands)
                            res |= b;
                    }
                    case '&' -> {
                        res = true;
                        for (boolean b : operands)
                            res &= b;
                    }
                }
                stk.push(res ? 't' : 'f');
            } else if (c == ',')
                ;
            else
                stk.push(c);
        }
        return stk.pop() == 't';
    }
}