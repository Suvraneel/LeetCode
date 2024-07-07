class Solution {
    public int minimumCardPickup(int[] cards) {
        int lt = 0, rt = 0, n = cards.length, ans = Integer.MAX_VALUE;
        Map<Integer, Integer> m = new HashMap<>();
        for(;rt<n; rt++){
            if(m.containsKey(cards[rt]))
                ans = Math.min(ans, rt+1-m.get(cards[rt]));
            m.put(cards[rt], rt);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}