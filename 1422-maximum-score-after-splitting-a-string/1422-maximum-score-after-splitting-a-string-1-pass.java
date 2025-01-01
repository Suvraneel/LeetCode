class Solution {
    public int maxScore(String s) {
        int n = s.length(), nZeros = 0, nOnes = 0, maxScore = -n;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0')
                nZeros++;
            else
                nOnes++;
            // At posn. i, score = nZeros + totalOnes(Unknown) - nOnes
            maxScore = Math.max(maxScore, nZeros - nOnes);
        }
        nOnes += s.charAt(n - 1) - '0';
        return maxScore + nOnes; // As now, totalOnes is known.
    }
}