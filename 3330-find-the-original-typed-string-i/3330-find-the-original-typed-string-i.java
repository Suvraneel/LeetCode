class Solution {
    public int possibleStringCount(String word) {
        char prev = word.charAt(0);
        int ans = 0;
        for (char c : word.toCharArray())
            if (prev == c)
                ans++;
            else
                prev = c;
        return ans;
    }
}