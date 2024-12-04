class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int p1 = 0, p2 = 0;
        for(; p1<str1.length() && p2<str2.length(); p1++){
            char c1 = str1.charAt(p1), c2 = str2.charAt(p2);
            if(c1 == c2 || c1 + 1 == c2 || c1-25==c2)
                p2++;
        }
        return p2 == str2.length();
    }
}