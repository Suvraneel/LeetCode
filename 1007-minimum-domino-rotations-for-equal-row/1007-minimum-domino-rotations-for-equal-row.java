class Solution {
    private int checkValid(int[] tops, int[] bottoms, int x) {
        int n = tops.length, cTop = 0, cBot = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x)
                return -1;
            if (tops[i] == x)
                cTop++;
            if (bottoms[i] == x)
                cBot++;
        }
        return Math.min(n - cTop, n - cBot);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, a = tops[0], b = bottoms[0];
        int ansB = checkValid(tops, bottoms, b);
        if (ansB != -1)
            return ansB;
        int ansA = checkValid(tops, bottoms, a);
        return Math.max(ansA, ansB);
    }
}