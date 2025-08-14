class Solution {
    public String largestGoodInteger(String num) {
        int[] freq = new int[10];
        int prev = -1, ans = -1;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (digit == prev) {
                if (++freq[digit] == 3)
                    ans = Math.max(ans, digit);
            } else {
                freq[digit] = 1;
                prev = digit;
            }
        }
        return ans == -1 ? "" : "" + ans + ans + ans;
    }
}