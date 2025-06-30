class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, len = 0;
        for (int lt = 0, rt = 0; rt < n; rt++) {
            while (nums[rt] - nums[lt] > 1)
                lt++;
            if (nums[rt] - nums[lt] == 1)
                len = Math.max(len, rt - lt + 1);
        }
        return len;
    }
}