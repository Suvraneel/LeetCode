class Solution {
    public char[][] rotateTheBox(char[][] box) {
        // 90 deg frozen flip... j' = lastCell - i; i' = j
        int m = box.length, n = box[0].length;
        char[][] box90 = new char[n][m]; // rows & cols count reversed
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                box90[i][j] = box[m - 1 - j][i];
        // turn on gravity
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++)
                if (box90[i][j] == '#') {
                    int y = i + 1;
                    while (y < n && box90[y][j] == '.') {
                        box90[y][j] = '#';
                        box90[y - 1][j] = '.';
                        y++;
                    }
                }
        }
        return box90;
    }
}