class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = n % 2 + 1; i < n; i += 2) {
            ans[i - 1] = i;
            ans[i] = -i;
        }
        return ans;
    }
}