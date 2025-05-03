class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, common = 0, commonFreq = 0;
        int[] freq = new int[7];
        for (int i = 0; i < n; i++) {
            if (++freq[tops[i]] > commonFreq) {
                common = tops[i];
                commonFreq = freq[tops[i]];
            }
            if (++freq[bottoms[i]] > commonFreq) {
                common = bottoms[i];
                commonFreq = freq[tops[i]];
            }
        }
        int cTop = 0, cBot = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != common && bottoms[i] != common)
                return -1;
            if (tops[i] == common)
                cTop++;
            if (bottoms[i] == common)
                cBot++;
        }
        return Math.min(n - cTop, n - cBot);
    }
}