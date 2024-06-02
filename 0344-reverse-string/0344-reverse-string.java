class Solution {
    public void reverseString(char[] s) {
        int lt = 0, rt = s.length-1;
        while(lt<rt){
            char temp = s[lt];
            s[lt++] = s[rt];
            s[rt--] = temp;
        }
    }
}