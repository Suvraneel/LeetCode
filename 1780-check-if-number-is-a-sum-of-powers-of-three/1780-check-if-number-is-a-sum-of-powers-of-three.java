class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] exp = new int[16];
        exp[0] = 1;
        int i = 1;
        for (; i < 16 && exp[i - 1] < n; i++)
            exp[i] = exp[i - 1] * 3;
        for (int rt = --i, sum = n; rt >= 0 && sum > 0; rt--) {
            if (exp[rt] <= sum)
                sum -= exp[rt];
            if (sum == 0)
                return true;
        }
        return false;
    }
}