class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> stk = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!stk.isEmpty() && stk.peek()[0]>=prices[i]){
                int[] top = stk.pop();
                prices[top[1]] = top[0] - prices[i];
            }
            stk.push(new int[]{prices[i], i});
        }
        return prices;
    }
}