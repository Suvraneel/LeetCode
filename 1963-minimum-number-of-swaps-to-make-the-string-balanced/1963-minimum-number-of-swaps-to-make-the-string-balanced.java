class Solution {
    public int minSwaps(String s) {
        int n = s.length(), lt = 0, rt = 0;
        char[] cs = s.toCharArray();
        for (; rt < n; rt++) {
            cs[lt] = cs[rt];
            if (lt > 0 && cs[rt] == ']' && cs[lt - 1] == '[')
                lt--;
            else
                lt++;
        }
        // System.out.println(s.substring(0, lt));
        return (int)Math.ceil(lt/4.0);
    }
}