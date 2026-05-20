class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int m, n;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0))
                    continue;
                vis[i][j] = true;
                ans |= solve(board, word, 1, i, j, vis);
                vis[i][j] = false;
            }
        }
        return ans;
    }

    boolean solve(char[][] board, String word, int idx, int x, int y, boolean[][] vis) {
        if (idx == word.length())
            return true;
        boolean ans = false;
        for (int[] d : dirs) {
            int X = x + d[0], Y = y + d[1];
            if (X < 0 || X >= m || Y < 0 || Y >= n || vis[X][Y] || word.charAt(idx) != board[X][Y])
                continue;
            vis[X][Y] = true;
            ans |= solve(board, word, idx + 1, X, Y, vis);
            vis[X][Y] = false;
        }
        return ans;
    }
}