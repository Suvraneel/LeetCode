class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<spaces.length; i++){
            String rem = sb.substring(spaces[i]+i);
            sb.setLength(spaces[i]+i);
            sb.append(" ").append(rem);
        }
        return sb.toString();
    }
}