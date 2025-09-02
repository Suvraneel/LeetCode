class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, count = 0;
        for (int i = 0; i < n; i++) {
            int[] B = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int[] A = points[j];
                if (A[0] <= B[0] && A[1] >= B[1]) { // A is on upper left of B
                    boolean hasPtsOnRect = false;
                    // System.out.println(Arrays.toString(A) + Arrays.toString(B));
                    for (int k = 0; k < n; k++) { // check for points on rectangle formed
                        if (i == k || j == k)
                            continue;
                        int[] C = points[k];
                        if (C[0] >= A[0] && C[0] <= B[0] && C[1] <= A[1] && C[1] >= B[1]) { // inside rect
                            hasPtsOnRect = true;
                            // System.out.println("point found inside rect:\t" + Arrays.toString(C));
                            break;
                        }
                    }
                    if (!hasPtsOnRect)
                        count++;
                }
            }
        }
        return count;
    }
}