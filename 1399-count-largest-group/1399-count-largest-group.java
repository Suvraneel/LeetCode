class Solution {
    public int countLargestGroup(int n) {
        int[] freq = new int[40];
        for (int i = 1; i <= n; i++) {
            int key = sumOfDigits(i);
            freq[key]++;
        }
        int maxSize = 0, count = 0;
        for (int i = 1; i < 40; i++) {
            if (freq[i] > maxSize) {
                maxSize = freq[i];
                count = 1;
            } else if (freq[i] == maxSize)
                count++;
        }
        return count;
    }

    private int sumOfDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}