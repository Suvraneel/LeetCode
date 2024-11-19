class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int n = nums.length;
        long sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + sum + "\t" + window);
            if (!window.contains(nums[i])) {
                if (window.size() < k) {
                    window.add(nums[i]);
                    sum += nums[i];
                } else {
                    window.add(nums[i]);
                    window.remove(nums[i - k]);
                    sum += nums[i] - nums[i - k];
                    ans = Math.max(sum, ans);
                }
            } else {
                while (!window.isEmpty() && window.contains(nums[i])) {
                    sum -= nums[i - window.size()];
                    window.remove(nums[i - window.size()]);
                }
            }
        }
        return ans;
    }
}