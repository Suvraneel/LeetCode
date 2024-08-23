class Solution {
    public String fractionAddition(String expression) {
        String[] operands = expression.split("/|(?=[+-])");
        System.out.println(Arrays.toString(operands));

        int num = 0, denom = 1;
        for (int i = 0; i < operands.length; i += 2) {
            int currNum = Integer.valueOf(operands[i]);
            int currDenom = Integer.valueOf(operands[i + 1]);
            num = num * currDenom + currNum * denom;    // Cross-multiplication
            denom = denom * currDenom;
        }
        // Convert to proper fraction by diving by HCF
        int gcd = Math.abs(FindGCD(num, denom));
        num /= gcd;
        denom /= gcd;
        return num + "/" + denom;
    }

    // Euclid's Algo
    private int FindGCD(int a, int b) {
        if (a == 0) return b;
        return FindGCD(b % a, a);
    }
}