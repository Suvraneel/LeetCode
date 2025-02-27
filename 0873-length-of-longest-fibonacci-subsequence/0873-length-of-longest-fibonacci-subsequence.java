class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, maxStreak = 0;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fib1 = arr[i], fib2 = arr[j], fib3 = fib1 + fib2, streak = 2;
                while (set.contains(fib3)) {
                    streak++;
                    fib1 = fib2;
                    fib2 = fib3;
                    fib3 = fib1 + fib2;
                }
                maxStreak = Math.max(streak, maxStreak);
            }
        }
        return maxStreak > 2 ? maxStreak : 0;
    }
}