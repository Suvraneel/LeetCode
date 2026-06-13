class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String s: words){
            long sum = 0;
            for(char c: s.toCharArray())
                sum += weights[c-'a'];
            sb.append((char)('z'-(int)(sum%26)));
        }
        return sb.toString();
    }
}