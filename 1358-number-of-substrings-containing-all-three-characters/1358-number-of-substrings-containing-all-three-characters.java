class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), lt = 0, rt = 0, ans = 0;
        int[] lastPosn = new int[3];
        Arrays.fill(lastPosn, -1);
        while (rt < n) {
            lastPosn[s.charAt(rt) - 'a'] = rt++;
            ans += 1 + Math.min(Math.min(lastPosn[0], lastPosn[1]), lastPosn[2]);
        }
        return ans;
    }
}