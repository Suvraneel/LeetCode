class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        char[] cs = s1.toCharArray();
        Arrays.sort(cs);
        String S1 = new String(cs);
        for (int i = 0; i <= n2 - n1; i++) {
            char[] sub = s2.substring(i, i + n1).toCharArray();
            Arrays.sort(sub);
            if(new String(sub).equals(S1))
                return true;
            // System.out.println(sub);
        }
        return false;
    }
}