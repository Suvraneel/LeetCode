class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        Set<Integer> vowels = new HashSet<>(Arrays.asList(0, 'e' - 'a', 'i' - 'a', 'o' - 'a', 'u' - 'a'));
        int maxVowelFreq = 0, maxConsonantFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (vowels.contains(i))
                maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
            else
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
        }
        return maxVowelFreq + maxConsonantFreq;
    }
}