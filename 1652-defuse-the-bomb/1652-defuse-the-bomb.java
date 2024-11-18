class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length, sum = 0;
        int[] ans = new int[n];
        if (k == 0)
            return ans;
        boolean isNegative = k < 0;
        if (isNegative)
            k = -k;
        for (int i = 0; i < k; i++)
            sum += code[i];
        for (int i = k; i < n + k; i++) {
            sum -= code[i - k];
            sum += code[i % n];
            if (isNegative)
                ans[(i + 1) % n] = sum;
            else
                ans[i - k] = sum;
        }
        return ans;
    }
}