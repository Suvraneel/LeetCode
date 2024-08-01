class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        if (n < 3)
            return n;
        int ways1Step = 1, ways2Step = 2;
        for (int i = 3; i <= n; i++){
            int temp = ways1Step + ways2Step;
            ways1Step = ways2Step;
            ways2Step = temp;
        }
        return ways2Step;
    }
}