class Solution {
    public boolean canSortArray(int[] nums) {
        int prevBitCount = Integer.bitCount(nums[0]),
                minElemInGrp = nums[0], maxElemInGrp = nums[0], maxElemInPrevGrp = -1;
        for (int i : nums) {
            if (Integer.bitCount(i) == prevBitCount) {
                maxElemInGrp = Math.max(maxElemInGrp, i);
                minElemInGrp = Math.min(minElemInGrp, i);
            } else {
                if (maxElemInPrevGrp > minElemInGrp)
                    return false;
                maxElemInPrevGrp = maxElemInGrp;
                minElemInGrp = i;
                maxElemInGrp = i;
                prevBitCount = Integer.bitCount(i);
            }
        }
        return maxElemInPrevGrp < minElemInGrp;
    }
}