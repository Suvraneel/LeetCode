class Solution {
    public int reverseDegree(String s) {
        int n = s.length(), sum = 0;
        for (int i = 0; i < n; i++)
            sum += (26 - (s.charAt(i) - 'a')) * (i + 1);
        return sum;
    }
}