class Solution {
    public int passThePillow(int n, int time) {
        int round = time/n, offset = time%n;
        return round%2==0?offset+1:n-offset-1;
    }
}