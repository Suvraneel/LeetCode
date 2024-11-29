class Solution {
    public int minimumTime(int[][] grid) {
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) // stuck at starting pt.
            return -1;
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { grid[0][0], 0, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int time = top[0], x = top[1], y = top[2];
            // System.out.println(Arrays.toString(top));
            if (x == m - 1 && y == n - 1)
                return time;
            if (vis[x][y])
                continue;
            vis[x][y] = true;
            for (int[] d : dirs) {
                int X = x + d[0], Y = y + d[1];
                if (X < 0 || Y < 0 || X >= m || Y >= n || vis[X][Y])
                    continue;

                // Calculate wait time reqd. to move to next cell
                // Odd/Even signifies stale square moves reqd. to wait out
                int waitTime = ((grid[X][Y] - time) % 2 == 0) ? 1 : 0;
                int nextTime = Math.max(grid[X][Y] + waitTime, time + 1);
                pq.offer(new int[] { nextTime, X, Y });
            }
        }
        return -1;
    }
}