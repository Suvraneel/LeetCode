class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int diff[] = new int[s.length()];
        int lt = 0, rt = 0, cost = 0, maxLen = 0;
        while (rt < s.length()) {
            diff[rt] = Math.abs(s.charAt(rt) - t.charAt(rt));
            cost += diff[rt++];
            while (cost > maxCost)
                cost -= diff[lt++];
            maxLen = Math.max(maxLen, rt - lt);
        }
        return maxLen;
    }
}