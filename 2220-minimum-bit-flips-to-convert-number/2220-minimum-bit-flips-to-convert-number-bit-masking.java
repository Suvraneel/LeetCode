class Solution {
    public int minBitFlips(int start, int goal) {
        // identify bits needing flip
        int xor = start ^ goal;
        int parity = 0; // count parity
        while (xor > 0) {
            xor &= (xor - 1);
            parity++;
        }
        return parity;
    }
}