class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int lt = 0, rt = 0, cost = 0, maxLen = 0, n = s.length();
        int diff[] = new int[n];
        while (rt < n) {
            diff[rt] = Math.abs(s.charAt(rt) - t.charAt(rt));
            cost += diff[rt++];
            while (cost > maxCost)
                cost -= diff[lt++];
            maxLen = Math.max(maxLen, rt - lt);
        }
        return maxLen;
    }
}