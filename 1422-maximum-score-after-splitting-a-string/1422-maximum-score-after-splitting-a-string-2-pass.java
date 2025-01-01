class Solution {
    public int maxScore(String s) {
        int n = s.length(), nOnes = 0, maxScore = 0, score;
        byte[] binary = new byte[n];
        for (int i = 0; i < n; i++) {
            binary[i] = (byte)(s.charAt(i) - '0');
            nOnes += binary[i];
        }
        score = nOnes;
        for (int i = 0; i < n - 1; i++) {
            if (binary[i] == 0)
                score++;
            else score--;
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}