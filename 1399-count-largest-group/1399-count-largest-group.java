class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int key = sumOfDigits(i);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        int maxSize = 0, count = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxSize) {
                maxSize = e.getValue();
                count = 1;
            } else if (e.getValue() == maxSize)
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