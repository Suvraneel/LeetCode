class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++)
            if (isSymmetric(i))
                count++;
        return count;
    }

    private boolean isSymmetric(int x) {
        int len = (int) Math.log10(x) + 1, sum = 0;
        if ((len & 1) == 1)
            return false;
        for (int i = 0; i < len / 2; i++) {
            sum += x % 10;
            x /= 10;
        }
        for (int i = len / 2; i < len; i++) {
            sum -= x % 10;
            x /= 10;
        }
        return (sum == 0);
    }
}