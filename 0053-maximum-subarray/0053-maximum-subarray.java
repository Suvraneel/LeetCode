class Solution {
    public int maxSubArray(int[] nums) {
        int cumsum = 0, maxm = -Integer.MIN_VALUE;
        for (int lt = 0, rt = 0; rt < nums.length; rt++) {
            while (cumsum < 0 && lt <= rt)
                cumsum -= nums[lt++];
            cumsum += nums[rt];
            // System.out.println(cumsum + "\t->" + nums[lt] + "\t" + nums[rt]);
            maxm = Math.max(cumsum, maxm);
        }
        return maxm;
    }
}