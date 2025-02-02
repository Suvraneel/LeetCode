class Solution {
    public boolean check(int[] nums) {
        boolean pivotFound = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                if (pivotFound)
                    return false;
                else
                    pivotFound = true;
        }
        return nums[nums.length - 1] < nums[0] || !pivotFound;
    }
}