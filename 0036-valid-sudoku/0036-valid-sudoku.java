class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            boolean[] vis = new boolean[10];
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                if (vis[board[i][j] - '0'])
                    return false;
                vis[board[i][j] - '0'] = true;
            }
        }
        for (int j = 0; j < n; j++) {
            boolean[] vis = new boolean[10];
            for (int i = 0; i < m; i++) {
                if (board[i][j] == '.')
                    continue;
                if (vis[board[i][j] - '0'])
                    return false;
                vis[board[i][j] - '0'] = true;
            }
        }
        for (int g = 0; g < 3; g++) {
            for (int h = 0; h < 3; h++) {
                boolean[] vis = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[g * 3 + i][h * 3 + j] == '.')
                            continue;
                        if (vis[board[g * 3 + i][h * 3 + j] - '0'])
                            return false;
                        vis[board[g * 3 + i][h * 3 + j] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}