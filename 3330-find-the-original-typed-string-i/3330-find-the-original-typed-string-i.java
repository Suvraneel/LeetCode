class Solution {
    public int possibleStringCount(String word) {
        char prev = word.charAt(0);
        int count = 0, ans = 0;
        for(char c: word.toCharArray()){
            if(prev == c)
                count++;
            else {
                ans += count - 1;
                count = 1;
                prev = c;
            }
        }
        ans += count;
        return ans;
    }
}