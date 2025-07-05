class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        int maxI = 0;
        for (int i : arr) {
            freq[i]++;
            maxI = Math.max(maxI, i);
        }
        for (int i = maxI; i > 0; i--)
            if (freq[i] == i)
                return i;
        return -1;
    }
}