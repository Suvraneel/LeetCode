class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, runningSum = 0, expectedSum = mean * (m + n);
        for (int r : rolls)
            runningSum += r;
        int diff = expectedSum - runningSum;
        if (diff < n || diff > 6 * n)
            return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        diff -= n;
        int sixes = diff / 5;
        for (int i = 0; i < sixes; i++)
            ans[i] = 6;
        ans[n - 1] += diff % 5;
        return ans;
    }
}