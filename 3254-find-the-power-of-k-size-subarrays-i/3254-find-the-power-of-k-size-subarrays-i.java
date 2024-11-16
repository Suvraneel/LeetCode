class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length, rt = 1, prevInflection = 0;
        if (n == 1)
            return nums;
        int[] pow = new int[n - k + 1];
        Arrays.fill(pow, -1);
        for (; rt < n; rt++) {
            if (nums[rt - 1] != nums[rt] - 1)
                prevInflection = rt;
            // System.out.println(nums[rt] + "\t" + prevInflection);
            if (rt - k + 1 >= prevInflection)
                pow[rt - k + 1] = nums[rt];
        }
        return pow;
    }
}