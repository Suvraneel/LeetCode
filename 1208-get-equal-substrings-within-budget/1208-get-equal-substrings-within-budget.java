class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int n = s.length();
        int diff[] = new int[n];
        for (int i = 0; i < n; i++)
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        // for (int i = 0; i < n && cost <= maxCost; i++) {
        //     maxLen++;
        //     cost += diff[i];
        // }
        int lt = 0, rt = 0, cost = 0;
        while (rt < n) {
            while (cost > maxCost)
                cost -= diff[lt++];
            while (rt < n && cost <= maxCost)
                cost += diff[rt++];
            maxLen = Math.max(maxLen, rt - lt - 1);
            // System.out.println(maxLen);
        }
        return maxLen;
    }
}