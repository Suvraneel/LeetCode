class Solution {
    public boolean isPowerOfTwo(int n) {
        int parity = 0;
        while (n > 0) {
            parity += n % 2;
            n = n >> 1;
        }
        // System.out.println(parity);
        return parity == 1;
    }
}