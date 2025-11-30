class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> modBucket = new HashMap<>();
        modBucket.put(0, -1);
        int n = nums.length, target = 0, prefixSum = 0, ans = n;
        for (int i : nums)
            target = (target + i) % p;
        if (target == 0)
            return 0;
        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int modP = (prefixSum - target + p) % p;
            if (modBucket.containsKey(modP))
                ans = Math.min(ans, i - modBucket.get(modP));
            modBucket.put(prefixSum, i);
        }
        return ans == n ? -1 : ans;
    }
}