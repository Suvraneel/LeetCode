class Solution {
    public String removeDigit(String number, char digit) {
        char[] cs = number.toCharArray();
        String ans = "";
        for(int i=0; i<cs.length-1; i++){
            if(cs[i]==digit){
                if(cs[i]<cs[i+1])
                    return String.valueOf(number.substring(0, i)+number.substring(i+1));
            }
        }
        int li = number.lastIndexOf(digit);
        return String.valueOf(number.substring(0, li)+number.substring(li+1));
    }
}