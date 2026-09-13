class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length, maxOverlap = 0;
        int[][] imgBig = new int[n * 3][n * 3];
        for (int i = n; i < 2 * n; i++)
            for (int j = n; j < 2 * n; j++)
                imgBig[i][j] = img2[i - n][j - n];
        for (int x = 0; x < 2 * n; x++) {
            for (int y = 0; y < 2 * n; y++) {
                int overlap = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        overlap += (img1[i][j] & imgBig[i + x][j + y]);
                    }
                }
                maxOverlap = Math.max(overlap, maxOverlap);
            }
        }
        return maxOverlap;
    }
}