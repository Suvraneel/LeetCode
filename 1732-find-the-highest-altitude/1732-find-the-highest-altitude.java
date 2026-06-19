class Solution {
    public int largestAltitude(int[] gain) {
        int maxm = 0, altitude = 0;
        for (int i : gain)
            maxm = Math.max(maxm, altitude += i);
        return maxm;
    }
}