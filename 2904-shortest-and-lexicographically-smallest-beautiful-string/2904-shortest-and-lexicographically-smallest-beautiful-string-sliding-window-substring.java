class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int lt = 0, rt = 0, n = s.length();
        String ans = "";
        for (; rt < n; rt++) {
            if (s.charAt(rt) == '1')
                k--;
            if (k == 0) {
                while (lt < rt && s.charAt(lt) != '1')
                    lt++;
                // System.out.println(s.substring(lt, rt + 1));
                ans = lexMin(ans, s.substring(lt, rt + 1));
                lt++;
                k++;
            }
        }
        return ans;
    }

    String lexMin(String a, String b) {
        if (a == "")
            return b;
        if (a.length() == b.length())
            return a.compareTo(b) < 0 ? a : b;
        return a.length() < b.length() ? a : b;
    }
}