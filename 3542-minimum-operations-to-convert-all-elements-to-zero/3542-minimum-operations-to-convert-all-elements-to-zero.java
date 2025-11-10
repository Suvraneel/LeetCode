class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        return op(nums, n, 0, n - 1);
    }

    private int op(int[] nums, int n, int lt, int rt) {
        // System.out.println(Arrays.toString(nums));
        if (lt > rt)
            return 0;
        else if (lt == rt) {
            if (nums[lt] == 0)
                return 0;
            nums[lt] = 0;
            return 1;
        }
        int minm = Integer.MAX_VALUE, prev = -1, ops = 1;
        for (int i = lt; i <= rt; i++){
            if(nums[i]==0){
                ops += op(nums, n, prev+1, i-1);
                prev = i;
                continue;
            }
            minm = Math.min(minm, nums[i]);        
        }
        for (int i = lt; i <= rt; i++)
            if (nums[i] == minm) {
                nums[i] = 0;
                ops += op(nums, n, prev + 1, i - 1);
                prev = i;
            }
        ops += op(nums, n, prev + 1, n - 1);
        return ops;
    }
}