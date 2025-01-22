class Solution {
    public int[][] highestPeak(int[][] isWater) {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int m = isWater.length, n = isWater[0].length;
        int[][] ht = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for (int[] r : ht)
            Arrays.fill(r, -1);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (isWater[i][j] == 1)
                    q.add(new Pair<>(i, j));
        int currHt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> p = q.remove();
                int i = p.getKey(), j = p.getValue();
                if (vis[i][j])
                    continue;
                ht[i][j] = currHt;
                vis[i][j] = true;
                for (int[] d : dirs) {
                    int I = i + d[0], J = j + d[1];
                    if (I >= 0 && J >= 0 && I < m && J < n)
                        q.add(new Pair<>(I, J));
                }
            }
            currHt++;
        }
        return ht;
    }
}