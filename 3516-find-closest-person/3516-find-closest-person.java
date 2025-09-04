class Solution {
    public int findClosest(int x, int y, int z) {
        int delta = Math.abs(x - z) - Math.abs(y - z);
        return delta == 0 ? 0 : delta < 0 ? 1 : 2;
    }
}