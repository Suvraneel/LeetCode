class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        int count = 0;
        for (int[] pair : dominoes) {
            int pairSum = Math.min(10 * pair[0] + pair[1], 10 * pair[1] + pair[0]);
            count += freq[pairSum];
            freq[pairSum]++;
        }
        return count;
    }
}