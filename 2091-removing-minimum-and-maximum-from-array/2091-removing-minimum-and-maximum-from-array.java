class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxI = 0, minI = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxI = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minI = i;
            }
        }
        int largerIdx = Math.max(minI, maxI), smallerIdx = Math.min(minI, maxI);
        int frontDelete = largerIdx + 1;
        int endDelete = n - smallerIdx;
        int flankDelete = smallerIdx + 1 + n - largerIdx;
        // System.out.println(frontDelete + "\t" + endDelete + "\t" + flankDelete);
        return Math.min(Math.min(frontDelete, endDelete), flankDelete);
    }
}