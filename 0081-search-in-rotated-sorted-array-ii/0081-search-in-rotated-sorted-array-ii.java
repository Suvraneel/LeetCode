class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length, lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[lt] <= nums[mid]) {
                if (nums[lt] <= target && target < nums[mid])
                    rt = mid - 1;
                else
                    lt++;
            // System.out.println("Left half sorted");
            } else if (nums[mid] <= nums[rt]) {
                if (nums[mid] < target && target <= nums[rt])
                    lt = mid + 1;
                else
                    rt--;
                // System.out.println("Right half sorted");
            }
            // System.out.println(lt+"\t"+rt);
        }
        return false;
    }
}