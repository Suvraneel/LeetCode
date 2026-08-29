class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int sr = source[0], sc = source[1], tr = target[0], tc = target[1];
        if ((sr + sc) % 2 != (tr + tc) % 2) // parity mismatch => opp. colored squares
            return -1;
        if (Math.abs(1.0 * (tc - sc) / (tr - sr)) == 1) // slope = n*pi/2 => same diagonal
            return 1;
        return 2;
    }
}