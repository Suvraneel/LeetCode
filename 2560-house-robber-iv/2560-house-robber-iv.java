class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length, lt = 1, rt = Arrays.stream(nums).max().getAsInt();
        while (lt < rt) {
            int mid = (lt + rt)/ 2, possibleThefts = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    possibleThefts++;
                    i++; // skip adjacent if theft is done in curr posn
                }
            }
            if (possibleThefts >= k)
                rt = mid;
            else 
                lt = mid + 1;
        }
        return lt;
    }
}