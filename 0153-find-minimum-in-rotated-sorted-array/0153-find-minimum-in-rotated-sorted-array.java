class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, lt = 0, rt = n - 1;
        while(lt != rt){
            int mid = ((lt + rt + (rt < lt ? n : 0)) / 2) % n;
            if(nums[mid] < nums[rt])
                rt = mid;
            else lt = mid + 1;
        }
        return nums[lt];
    }
}