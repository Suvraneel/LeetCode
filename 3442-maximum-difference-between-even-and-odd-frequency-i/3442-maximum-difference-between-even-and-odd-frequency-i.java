class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int maxOdd = -1, minEven = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                ;
            else if ((freq[i] & 1) == 1)
                maxOdd = Math.max(maxOdd, freq[i]);
            else
                minEven = Math.min(minEven, freq[i]);
        }
        // System.out.println(maxOdd + "\t" + minEven);
        return maxOdd - minEven;
    }
}