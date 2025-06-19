class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, partitions = 0;
        for (int i = 0, start = nums[0]; i < n; i++) {
            if (nums[i] - start <= k)
                continue;
            partitions++;
            start = nums[i];
        }
        return ++partitions;
    }
}