class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2])
            return "none";
        if (nums[0] == nums[1]) {
            if (nums[1] == nums[2])
                return "equilateral";
            return "isosceles";
        }
        return "scalene";
    }
}