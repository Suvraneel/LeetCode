class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int l = 0, w = 0, maxDiagSq = 0;
        for (int[] rect : dimensions) {
            int diagSq = rect[0] * rect[0] + rect[1] * rect[1];
            if (diagSq > maxDiagSq) {
                l = rect[0];
                w = rect[1];
                maxDiagSq = diagSq;
            } else if (diagSq == maxDiagSq) {
                int area = rect[0] * rect[1];
                if (area > l * w) {
                    l = rect[0];
                    w = rect[1];
                }
            }
        }
        return l * w;
    }
}