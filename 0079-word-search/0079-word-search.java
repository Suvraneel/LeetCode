class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int m, n;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0))
                    continue;
                board[i][j] = '#';
                ans |= solve(board, word, 1, i, j);
                board[i][j] = word.charAt(0);
            }
        }
        return ans;
    }

    boolean solve(char[][] board, String word, int idx, int x, int y) {
        if (idx == word.length())
            return true;
        boolean ans = false;
        for (int[] d : dirs) {
            int X = x + d[0], Y = y + d[1];
            if (X < 0 || X >= m || Y < 0 || Y >= n || word.charAt(idx) != board[X][Y])
                continue;
            board[X][Y] = '#';
            ans |= solve(board, word, idx + 1, X, Y);
            board[X][Y] = word.charAt(idx);
        }
        return ans;
    }
}