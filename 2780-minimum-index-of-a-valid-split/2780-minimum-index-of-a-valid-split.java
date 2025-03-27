class Solution {
    public int minimumIndex(List<Integer> nums) {
        // Find dominant element (mode)
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.size(), maxCount = 0, mode = -1;
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            if (freq.get(i) > maxCount) {
                maxCount = freq.get(i);
                mode = i;
            }
        }
        // Compute dominant element counts prefix sum
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == mode)
                prefixSum++;
            // System.out.println(i + 1 + "\t" + prefixSum);
            if ((i+1) / 2 < prefixSum && (n - 1 - i) / 2 < (maxCount - prefixSum))
                return i;
        }
        return -1;
    }
}