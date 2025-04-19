class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int lt, int rt){
        while(lt<rt){
            int temp = nums[lt];
            nums[lt] = nums[rt];
            nums[rt] = temp;
            lt++;
            rt--;
        }
    }
}