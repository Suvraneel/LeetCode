class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for (int n : nums)
            freq[n]++;
        int maxFreq = 0, freqOfMaxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                freqOfMaxFreq = 1;
            } else if (f == maxFreq)
                freqOfMaxFreq++;
        }
        return freqOfMaxFreq * maxFreq;
    }
}