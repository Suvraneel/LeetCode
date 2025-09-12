class Solution {
    public boolean doesAliceWin(String s) {
        return s.chars().anyMatch(c -> "aeiou".indexOf(c) != -1);
    }
}