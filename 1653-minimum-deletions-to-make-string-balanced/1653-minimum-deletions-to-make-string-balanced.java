class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        char[] S = s.toCharArray();
        int suffixA = 0, prefixB = 0, deletionCt = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
            if(S[i]=='a')
                suffixA++;
        for(int i=0; i<n; i++){
            if(S[i]=='a')
                --suffixA;
            deletionCt = Math.min(deletionCt, prefixB+suffixA);
            if(S[i]=='b')
                prefixB++;
        }
        return deletionCt;
    }
}