class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int n = nums.length, prefixSum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            ans += prefixMap.getOrDefault(prefixSum - k, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }
}