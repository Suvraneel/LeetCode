class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length(), prefixSum = 0;
        int[] conversion = new int[n+1];
        for(int[] sh: shifts){
            if(sh[2]==1){
                conversion[sh[0]]++;
                conversion[sh[1]+1]--;
            } else {
                conversion[sh[0]]--;
                conversion[sh[1]+1]++;
            }
        }
        char[] cs = s.toCharArray();
        for(int i=0; i<n; i++){
            prefixSum = (prefixSum + conversion[i]) % 26 + 26;
            cs[i] = (char)((cs[i] - 'a' + prefixSum) % 26 + 'a');
        }
        return new String(cs);
    }
}