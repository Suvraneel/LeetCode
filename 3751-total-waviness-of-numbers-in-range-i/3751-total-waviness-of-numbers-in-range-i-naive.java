class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++)
            total += waviness(String.valueOf(i));
        return total;
    }

    int waviness(String s) {
        int n = s.length(), wav = 0;
        for (int i = 1; i < n - 1; i++)
            if (s.charAt(i) > Math.max(s.charAt(i - 1), s.charAt(i + 1))
                    || s.charAt(i) < Math.min(s.charAt(i - 1), s.charAt(i + 1)))
                wav++;
        return wav;
    }
}