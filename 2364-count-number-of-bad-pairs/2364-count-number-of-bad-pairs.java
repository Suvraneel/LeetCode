class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length, goodPairs = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i, prevHits = freq.getOrDefault(diff, 0);
            goodPairs += prevHits;
            freq.put(diff, prevHits + 1);
        }
        return (n * (n - 1) / 2) - goodPairs;
    }
}