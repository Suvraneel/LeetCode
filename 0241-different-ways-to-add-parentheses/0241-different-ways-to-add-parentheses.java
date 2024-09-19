class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] memo = new List[n][n];
        return solve(expression, memo, 0, n - 1);
    }

    List<Integer> solve(String expr, List<Integer>[][] memo, int lt, int rt) {
        if (memo[lt][rt] != null)
            return memo[lt][rt];
        if (expr.length() == 0)
            return new ArrayList<>();
        else if (expr.length() <= 2)
            return new ArrayList<>(List.of(Integer.parseInt(expr)));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c))
                continue;
            List<Integer> ltOperand = solve(expr.substring(0, i), memo, lt, i);
            List<Integer> rtOperand = solve(expr.substring(i + 1), memo, i + 1, rt);
            // System.out.println(expr.substring(0, i) + "\t" + expr.substring(i + 1));
            // System.out.println("ltOperands\t" + ltOperand);
            // System.out.println("rtOperands\t" + rtOperand);
            for (int l : ltOperand)
                for (int r : rtOperand) {
                    // System.out.println(l + "\t" + r);
                    res.add(switch (c) {
                        case '+' -> l + r;
                        case '-' -> l - r;
                        case '*' -> l * r;
                        default -> 0;
                    });
                }
        }
        return res;
    }
}