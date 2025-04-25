class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size(), prefix = 0;
        long ans = 0;
        Map<Integer, Integer> moduloBucket = new HashMap<>();
        moduloBucket.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k)
                prefix++;
            ans += moduloBucket.getOrDefault((prefix - k + modulo) % modulo, 0);
            moduloBucket.put(prefix % modulo, moduloBucket.getOrDefault(prefix % modulo, 0) + 1);
        }
        return ans;
    }
}