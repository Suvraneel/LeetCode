class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!stk.isEmpty() && prices[stk.peek()]>=prices[i])
                prices[stk.pop()] -= prices[i];
            stk.push(i);
        }
        return prices;
    }
}