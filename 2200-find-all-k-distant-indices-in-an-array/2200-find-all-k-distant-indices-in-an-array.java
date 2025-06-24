class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length, vis = 0;
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int i = Math.max(j - k, vis);
                for (; i <= Math.min(j + k, n - 1); i++)
                    ans.add(i);
                vis = i;
            }
        }
        return ans;
    }
}