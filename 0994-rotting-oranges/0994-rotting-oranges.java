class Solution {
    private static final int[][] dirs = {
            { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> pq = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int depth = 0, totalCt = 0, rottenCt = 0, nodesAtLevel;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottenCt++;
                    pq.offer(new int[] { i, j });
                }
                if (grid[i][j] != 0)
                    totalCt++;
            }
        nodesAtLevel = pq.size();
        if(totalCt==0)
            return 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            grid[top[0]][top[1]] = 0;
            // System.out.println(Arrays.toString(top) + "\t" + nodesAtLevel + "\t" + depth);
            for (int[] d : dirs) {
                int i = top[0] + d[0], j = top[1] + d[1];
                if (i < 0 || j < 0 || i >= m || j >= n)
                    continue;
                if (grid[i][j] == 1) {
                    rottenCt++;
                    grid[i][j] = 2;
                    pq.offer(new int[] { i, j });
                }
            }
            if (--nodesAtLevel == 0) {
                depth++;
                nodesAtLevel = pq.size();
            }
        }
        if (rottenCt < totalCt)
            return -1;
        return depth - 1;
    }
}