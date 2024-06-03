class Solution {
    public int appendCharacters(String s, String t) {
        int p1=0, p2=0;
        while(p1<s.length() && p2<t.length()){
            if(t.charAt(p2)==s.charAt(p1))
                p2++;
            p1++;
        }
        return t.length()-p2;
    }
}