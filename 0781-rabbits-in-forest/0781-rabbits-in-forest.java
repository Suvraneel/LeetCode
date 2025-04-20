class Solution {
    public int numRabbits(int[] answers) {
        int[] freq = new int[1001];
        int n = answers.length, count = 0;
        for (int i = 0; i < n; i++)
            freq[answers[i]]++;
        for (int i = 0; i < 1001; i++)
            count += (int) Math.ceil(freq[i] / (i + 1f)) * (i + 1);
        // System.out.println(Arrays.toString(freq));
        return count;
    }
}