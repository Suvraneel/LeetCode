class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> freqTotal = new HashMap<>();
        int MOD = 1_000_000_007, ans = 0;
        for (int i : nums)
            freqTotal.put(i, freqTotal.getOrDefault(i, 0) + 1);
        Map<Integer, Integer> freqRunning = new HashMap<>();
        for (int i : nums) {
            if (i == 0)
                continue;
            freqRunning.put(i, freqRunning.getOrDefault(i, 0) + 1);
            int target = 2 * i;
            ans = (ans + freqRunning.getOrDefault(target, 0)
                    * (freqTotal.getOrDefault(target, 0) - freqRunning.getOrDefault(target, 0))) % MOD;
        }
        return (ans + Math.max(0, freqTotal.getOrDefault(0, 0) - 2)) % MOD;
    }
}