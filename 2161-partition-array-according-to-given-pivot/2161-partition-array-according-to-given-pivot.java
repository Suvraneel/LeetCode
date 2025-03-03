class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, equal = 0, lt = 0, rt = 0, mid = 0;
        int[] larger = new int[n];
        for(; rt<n; rt++){
            if(nums[rt]<pivot){
                nums[lt++] = nums[rt];
            } else if(nums[rt]>pivot){
                larger[mid++] = nums[rt];
            } else equal++;
        }
        for(int i=0; i<equal; i++)
            nums[lt++] = pivot;
        mid = 0;
        while(lt<n)
            nums[lt++] = larger[mid++];
        return nums;
    }
}