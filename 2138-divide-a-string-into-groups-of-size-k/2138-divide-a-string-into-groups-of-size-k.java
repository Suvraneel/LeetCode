class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() % k != 0)
            sb.append(fill);
        int n = sb.length(), i = 0;
        String[] ans = new String[n / k];
        while (i < ans.length)
            ans[i] = sb.substring(i * k, ++i * k);
        return ans;
    }
}