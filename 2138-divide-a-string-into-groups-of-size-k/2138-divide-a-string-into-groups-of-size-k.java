class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() % k != 0)
            sb.append(fill);
        int n = sb.length();
        String[] ans = new String[n / k];
        for (int i = 0; i < ans.length; i++)
            ans[i] = sb.substring(i * k, i * k + k);
        return ans;
    }
}