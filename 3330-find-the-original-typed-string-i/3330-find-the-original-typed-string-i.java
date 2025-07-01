class Solution {
    public int possibleStringCount(String word) {
        char prev = '.';
        int ans = 1; // OG string
        for (char c : word.toCharArray())
            if (prev == c)
                ans++;
            else
                prev = c;
        return ans;
    }
}