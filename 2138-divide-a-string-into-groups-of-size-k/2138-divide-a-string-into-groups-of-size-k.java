class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[(int) Math.ceil(1.0 * n / k)];
        for (int i = 0; i < ans.length; i++)
            ans[i] = s.substring(i * k, Math.min(i * k + k, n));
        StringBuilder sb = new StringBuilder(ans[ans.length - 1]);
        while (sb.length() < k)
            sb.append(fill);
        ans[ans.length - 1] = sb.toString();
        return ans;
    }
}