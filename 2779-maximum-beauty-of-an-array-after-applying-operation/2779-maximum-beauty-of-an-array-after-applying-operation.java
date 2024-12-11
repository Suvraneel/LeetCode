class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length==1)
            return 1;
        int range = 0;
        for (int i : nums)
            range = Math.max(range, i);
        int[] beauty = new int[range + 1];
        for (int i : nums) {
            beauty[Math.max(i - k, 0)]++; // ignore negative range
            beauty[Math.min(i + k + 1, range)]--; // ignore out of range
        }
        int maxBeauty = 0, runningBeauty = 0;
        for (int b : beauty) {
            runningBeauty += b;
            maxBeauty = Math.max(maxBeauty, runningBeauty);
        }
        return maxBeauty;
    }
}