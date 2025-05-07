class Solution {
    int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] minReachTime = new int[m][n];
        for(int[] r: minReachTime)
            Arrays.fill(r, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            // System.out.println(Arrays.toString(top));
            int x = top[0], y = top[1], reachedAt = top[2];
            if (minReachTime[x][y] > reachedAt) {
                minReachTime[x][y] = reachedAt;
                bfs(x, y, m, n, reachedAt, moveTime, pq);
            }
        }
        return minReachTime[m - 1][n - 1];
    }

    private void bfs(int x, int y, int m, int n, int timeElapsed,
            int[][] moveTime, Queue<int[]> pq) {
        for (int[] d: dirs) {
            int X = x + d[0], Y = y + d[1];
            if (isValid(X, Y, m, n))
                pq.offer(new int[] { X, Y, Math.max(timeElapsed + 1, moveTime[X][Y] + 1) });
        }
    }
}