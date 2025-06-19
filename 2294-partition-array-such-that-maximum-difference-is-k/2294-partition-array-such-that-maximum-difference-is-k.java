class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, partitions = 0;
        for(int i=0, start = 0; i<n; i++){
            if(nums[i]-nums[start]<=k)
                continue;
            partitions++;
            start = i;
        }
        return ++partitions;
    }
}