class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String s = "" + i + i + i;
            if (num.contains(s))
                return s;
        }
        return "";
    }
}