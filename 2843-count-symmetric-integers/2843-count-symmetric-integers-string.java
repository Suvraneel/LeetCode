class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++)
            if (isSymmetric(i))
                count++;
        return count;
    }

    private boolean isSymmetric(int x) {
        String s = String.valueOf(x);
        int len = s.length(), sum = 0;
        if ((len & 1) == 1)
            return false;
        for (int i = 0; i < len / 2; i++)
            sum += s.charAt(i) - s.charAt(len - 1 - i);
        return (sum == 0);
    }
}