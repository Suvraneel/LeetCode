class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n<=nums[0])
            return n;
        for(int i=1; i<n; i++){
            int x = n-i;
            if(x>nums[i-1] && x<=nums[i])
                return x;
        }
        return -1;
    }
}