class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] universalFreq = new int[26];
        for (String s : words2) {
            int[] freq = new int[26];
            for (char c : s.toCharArray())
                freq[c - 'a']++;
            for (int i = 0; i < 26; i++)
                universalFreq[i] = Math.max(universalFreq[i], freq[i]);
        }
        List<String> universalStrings = new ArrayList<>();
        for (String s : words1) {
            int[] freq = new int[26];
            for (char c : s.toCharArray())
                freq[c - 'a']++;
            int i;
            for (i = 0; i < 26 && universalFreq[i] <= freq[i]; i++)
                ;
            if (i == 26)
                universalStrings.add(s);
        }
        return universalStrings;
    }
}