class Solution {
    public int getLucky(String s, int k) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cs)
            sb.append(c - 'a' + 1);
        // System.out.println(sb.toString());
        cs = sb.toString().toCharArray();
        int ans = 0;
        while (k-- > 0) {
            ans = 0;
            for (char c : cs)
                ans += c - '0';
            cs = String.valueOf(ans).toCharArray();
        }
        return ans;
    }
}