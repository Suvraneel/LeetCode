class Solution {
    private static int[][] blank = {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 }
    };
    private static int[][] fwdSlash = {
            { 0, 0, 1 },
            { 0, 1, 0 },
            { 1, 0, 0 }
    };;
    private static int[][] backSlash = {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
    };

    public int regionsBySlashes(String[] grid) {
        int n = grid.length, regionCt = 0;
        int[][] region = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            char[] cs = grid[i].toCharArray();
            for (int j = 0; j < n; j++)
                populateArea(region, cs[j], 3 * i, 3 * j);
        }

        n *= 3;

        // for (int i = 0; i < n; i++)
        //     System.out.println(Arrays.toString(region[i]));
        // System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (region[i][j] == 0) {
                    fillRegion(region, n, i, j);
                    regionCt++;
                }
            }
        }
        return regionCt;
    }

    private void populateArea(int[][] area, char c, int rowStart, int colStart) {
        int[][] cloner = switch (c) {
            case ' ' -> blank;
            case '/' -> fwdSlash;
            case '\\' -> backSlash;
            default -> blank;
        };
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                area[rowStart + i][colStart + j] = cloner[i][j];
        // System.out.println(Arrays.toString(area));
    }

    private void fillRegion(int[][] region, int n, int i, int j) {
        if (Math.min(i, j) < 0 || Math.max(i, j) >= n || region[i][j] == 1)
            return;
        region[i][j] = 1;
        fillRegion(region, n, i - 1, j);
        fillRegion(region, n, i + 1, j);
        fillRegion(region, n, i, j - 1);
        fillRegion(region, n, i, j + 1);
    }
}