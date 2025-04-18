class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length(), half = n / 2;
        for (int i = 0; i < half; i++)
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        return true;
    }
}