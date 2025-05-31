class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, rolls = 0;
        // Apply BFS since target is to figure out least no. of dice rolls (ie, nodes reached)
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n * n + 1];
        q.offer(1);
        while (!q.isEmpty()) {
            int sz = q.size();
            rolls++;
            while (sz-- > 0) {
                int node = q.poll();
                if (node == n * n)
                    return rolls - 1;
                for (int i = 1; i <= 6; i++) {
                    int label = node + i;
                    if (label > n * n || vis[label])
                        continue;
                    vis[label] = true;
                    int[] XY = findBoustrophedonCoords(label, n);
                    // System.out.println(label + "\t" + Arrays.toString(XY));
                    q.offer(board[XY[0]][XY[1]] == -1 ? label : board[XY[0]][XY[1]]);
                }
            }
        }
        return -1;
    }

    private int[] findBoustrophedonCoords(int label, int n) {
        int x = n - 1 - (label - 1) / n;
        int y = ((n - 1 - x) & 1) == 0 ? (label - 1) % n : n - 1 - ((label - 1) % n);
        return new int[] { x, y };
    }
}