class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxm = 0, ans = 0;
        for(int i: costs)
            maxm = Math.max(maxm, i);
        int[] counts = new int[maxm+1];
        for(int i: costs)
            counts[i]++;
        for(int i=0; i<counts.length; i++){
            if(coins > counts[i] * i){
                coins -= counts[i] * i;
                ans += counts[i];
            } else {
                ans += coins / i;
                break;
            }
        }
        return ans;
    }
}