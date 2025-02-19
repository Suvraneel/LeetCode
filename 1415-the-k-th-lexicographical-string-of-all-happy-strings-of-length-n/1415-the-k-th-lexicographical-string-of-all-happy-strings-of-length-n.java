class Solution {
    int count = 0;
    String ans = null;

    public String getHappyString(int n, int k) {
        char[] cs = new char[n];
        dfs(0, n, k, cs);
        return ans == null ? "" : ans;
    }

    private void dfs(int len, int n, int k, char[] cs) {
        System.out.println(Arrays.toString(cs));
        if (len == n){
            if (++count >= k && ans == null)
                ans = new String(cs);
            return;
        }
        for (int i = 0; i < 3; i++) {
            char c = (char) ('a' + i);
            if (len != 0 && cs[len - 1] == c)
                continue;
            cs[len] = c;
            dfs(len + 1, n, k, cs);
        }
    }
}