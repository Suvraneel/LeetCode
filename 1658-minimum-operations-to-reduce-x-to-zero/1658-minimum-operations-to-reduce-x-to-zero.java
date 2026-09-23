class Solution {
    public int minOperations(int[] nums, int x) {
        // sliding window: find subarray sum of "total(nums) - x". Complement is the answer
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1); // to satisfy cases where all digits from left can give x
        int totalSum = 0, n = nums.length, ans = n + 1;
        for (int i = 0; i < n; i++)
            totalSum += nums[i];
        int prefixSum = 0, complement = totalSum - x;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            m.put(prefixSum, i);
            if (m.containsKey(prefixSum - complement))
                ans = Math.min(ans, m.get(prefixSum - complement) + (n - i));
        }
        return ans == n + 1 ? -1 : ans;
    }
}