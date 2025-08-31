class Solution {
    int m = 9, n = 9;

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++)
                        if (isValid(i, j, k, board)) {
                            board[i][j] = k;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    return false; // dead end, backtrack
                }
        return true; // Constraint: It is guaranteed that the input board has only one solution.
    }

    private boolean isValid(int r, int c, char k, char[][] board) {
        for (int i = 0; i < m; i++) {
            if (board[i][c] == k)
                return false;
        }
        for (int j = 0; j < n; j++) {
            if (board[r][j] == k)
                return false;
        }
        int R = (int) (r / 3) * 3, C = (int) (c / 3) * 3;
        for (int i = R; i < R + 3; i++) {
            for (int j = C; j < C + 3; j++) {
                if (board[i][j] == k)
                    return false;
            }
        }
        return true;
    }
}