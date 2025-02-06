class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length, count = 0;
        Map<Integer, Integer> pdtMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int pdt = nums[i] * nums[j];
                pdtMap.put(pdt, pdtMap.getOrDefault(pdt, 0) + 1);
            }
        }
        for (Integer freq : pdtMap.values())
            count += freq * 8; // nP2 * 2P2 * 2P2
        return count;
    }
}