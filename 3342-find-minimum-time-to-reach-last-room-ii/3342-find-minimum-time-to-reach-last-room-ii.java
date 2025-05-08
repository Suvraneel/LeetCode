class Solution {
    int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length; // nRow, nCol
        int[][] minTime = new int[n][m]; // store min cost to reach a node
        for (int[] r : minTime)
            Arrays.fill(r, Integer.MAX_VALUE); // initialise all costs to INF
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // sort by reached At times
        pq.offer(new int[] { 0, 0, 0, 0 }); // start of path
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            // System.out.println(Arrays.toString(top));
            int x = top[0], y = top[1], reachedAt = top[2], alt = (top[3] == 0 ? 1 : 2); // x, y, time, isAlternate
            if (minTime[x][y] > reachedAt) { // better path?
                minTime[x][y] = reachedAt;
                for (int[] d : dirs) { // 4 directions
                    int X = x + d[0], Y = y + d[1]; // adjacent cell
                    if (X >= 0 && Y >= 0 && X < n && Y < m) // is valid cell ?
                        pq.offer(new int[] { X, Y, Math.max(reachedAt, moveTime[X][Y]) + alt, alt % 2 });
                }
            }
        }
        return minTime[n - 1][m - 1];
    }
}