class Solution {
    char[][] ans = new char[9][9];

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    boolean solve(char[][] board, int i, int j) {
        if (i == 9)
            return true;

        if (j == 9)
            return solve(board, i + 1, 0);

        if (board[i][j] != '.')
            return solve(board, i, j + 1);

        for (char d = '1'; d <= '9'; d++) {
            if (isSafe(board, i, j, d)) {
                board[i][j] = d;
                if (solve(board, i, j + 1))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    boolean isSafe(char[][] board, int i, int j, char d) {
        for (int k = 0; k < 9; k++)
            if (board[k][j] == d || board[i][k] == d || board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == d)
                return false;
        return true;
    }
}