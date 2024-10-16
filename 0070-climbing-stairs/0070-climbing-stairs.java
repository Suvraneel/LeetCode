class Solution {
    public int climbStairs(int n) {
        return solve(n);
    }
    private int solve(int n){
        if(n<=2)
            return n;
        return solve(n-1) + solve(n-2);
    }
}