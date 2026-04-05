class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> y--;
                case 'D' -> y++;
                case 'R' -> x++;
                case 'L' -> x--;
            }
        }
        return x == 0 && y == 0;
    }
}