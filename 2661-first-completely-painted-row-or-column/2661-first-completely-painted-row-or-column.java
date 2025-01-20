class Solution {
    private record Pair(int r, int c) {
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] paintedCellsInRow = new int[m], paintedCellsInCol = new int[n];
        Pair[] map = new Pair[m * n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                map[mat[i][j]] = new Pair(i, j);
        // System.out.println(Arrays.toString(map));
        for (int i = 0; i < arr.length; i++)
            if (++paintedCellsInRow[map[arr[i]].r] == n || ++paintedCellsInCol[map[arr[i]].c] == m)
                return i;
        return -1;
    }
}