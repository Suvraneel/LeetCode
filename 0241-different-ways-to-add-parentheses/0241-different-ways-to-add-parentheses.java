class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] memo = new List[n][n];
        return solve(expression, memo, 0, n - 1);
    }

    List<Integer> solve(String expr, List<Integer>[][] memo, int lt, int rt) {
        if (memo[lt][rt] != null)
            return memo[lt][rt];
        if (lt == rt)
            return memo[lt][rt] = new ArrayList<>(List.of(expr.charAt(lt) - '0'));
        else if (rt - lt == 1)
            return memo[lt][rt] = new ArrayList<>(List.of(Integer.parseInt(expr.substring(lt, rt + 1))));
        List<Integer> res = new ArrayList<>();
        for (int i = lt; i <= rt; i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c))
                continue;
            List<Integer> ltOperand = solve(expr, memo, lt, i - 1);
            List<Integer> rtOperand = solve(expr, memo, i + 1, rt);
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
        return memo[lt][rt] = res;
    }
}