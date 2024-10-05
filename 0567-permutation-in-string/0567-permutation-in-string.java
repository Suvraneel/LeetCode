class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2)
            return false;
        for (char c : s1.toCharArray())
            freq[c - 'a']++;
        char[] cs = s2.toCharArray();
        for (int i = 0; i < n1; i++)
            freq[cs[i] - 'a']--; // enter sliding window
        if (checkMatch(freq))
            return true;
        for (int i = n1; i < n2; i++) {
            freq[cs[i - n1] - 'a']++; // exit sliding window
            freq[cs[i] - 'a']--; // enter sliding window
            if (checkMatch(freq))
                return true;
        }
        return false;
    }

    private boolean checkMatch(int[] freq) {
        // System.out.println(Arrays.toString(freq));
        for (int i : freq)
            if (i != 0)
                return false;
        return true;
    }
}