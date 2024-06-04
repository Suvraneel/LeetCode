class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] S = s.toCharArray();
        for (char c : S)
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        int len = 0;
        boolean single = false;
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() % 2 != 0)
                single = true;
            len += ((int)(e.getValue()/2))*2;
        }
        if (single)
            len++;
        return len;
    }
}