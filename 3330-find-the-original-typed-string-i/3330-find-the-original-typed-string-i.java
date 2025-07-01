class Solution {
    public int possibleStringCount(String word) {
        char prev = word.charAt(0);
        int count = 0, ans = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (prev == c)
                count++;
            else {
                ans += count - 1;
                count = 1;
                prev = c;
            }
        }
        return ans += count;
    }
}