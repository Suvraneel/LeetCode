class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int n = nums.length, prefixSum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
            ans += prefixMap.getOrDefault(prefixSum - k, 0);
        }
        return ans + 1;
    }
}