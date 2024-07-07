class Solution {
    public int minimumCardPickup(int[] cards) {
        int lt = 0, rt = 0, n = cards.length, ans = n + 1;
        Map<Integer, Integer> m = new HashMap<>();
        for (; rt < n; rt++) {
            ans = Math.min(ans, rt - m.getOrDefault(cards[rt], -n) + 1);
            m.put(cards[rt], rt);
        }
        return ans > n ? -1 : ans;
    }
}