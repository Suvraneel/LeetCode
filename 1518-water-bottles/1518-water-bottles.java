class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        while (numBottles >= numExchange) {
            int get = numBottles / numExchange, rem = numBottles % numExchange;
            ans += numBottles - rem;
            numBottles = rem + get;
        }
        return ans += numBottles;
    }
}