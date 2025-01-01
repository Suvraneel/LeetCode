class Solution {
    public int maxScore(String s) {
        char[] cs = s.toCharArray();
        int z = 0, n = cs.length, maxScore = 0, ltScore = 0;
        for(char c: cs)
            if(c=='0')
                z++;
        for(int i=0; i<n-1; i++){
            if(cs[i]=='0')
                ltScore++;
            maxScore = Math.max(maxScore, 2 * ltScore + n - 1 - i - z);
        }
        return maxScore;
    }
}